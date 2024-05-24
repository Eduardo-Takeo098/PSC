document.addEventListener('DOMContentLoaded', function() {
    const menuToggle = document.getElementById('menu-toggle');
    const menu = document.getElementById('menu');

    const projectButton = document.getElementById('project-button');
    const projectFormModal = document.getElementById('project-form-modal');
    const closeModal = document.querySelector('.project-form-content .close');
    const projectForm = document.getElementById('project-form');

    menuToggle.addEventListener('click', function() {
        if (menu.style.display === 'none' || menu.style.display === '') {
            menu.style.display = 'flex';
        } else {
            menu.style.display = 'none';
        }
    });

    projectButton.addEventListener('click', function() {
        projectFormModal.style.display = 'block';
        loadCategories();
    });

    closeModal.addEventListener('click', function() {
        projectFormModal.style.display = 'none';
    });

    window.addEventListener('click', function(event) {
        if (event.target === projectFormModal) {
            projectFormModal.style.display = 'none';
        }
    });

    projectForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const taskName = document.getElementById('taskName').value;
        const taskDescription = document.getElementById('taskDescription').value;
        const taskUrlImg = document.getElementById('taskUrlImg').value;
        const categoryId = document.getElementById('category').value;

        const task = {
            taskName: taskName,
            taskDescription: taskDescription,
            taskUrlImg: taskUrlImg,
            categoryId: categoryId
        };

        fetch('/tasks', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(task)
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                projectFormModal.style.display = 'none';
                projectForm.reset();
                alert('Projeto e tarefa criados com sucesso');
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('Erro ao criar projeto e tarefa. Por favor, tente novamente.');
            });
    });

    function loadCategories() {
        fetch('/categories')
            .then(response => response.json())
            .then(categories => {
                const categorySelect = document.getElementById('category');
                categorySelect.innerHTML = '';
                categories.forEach(category => {
                    const option = document.createElement('option');
                    option.value = category.id;
                    option.textContent = category.name;
                    categorySelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error fetching categories:', error));
    }

    fetch('/tasks/groupedByCategory')
        .then(response => response.json())
        .then(data => {
            const tasksContainer = document.querySelector('.section:nth-child(2) ul');
            tasksContainer.innerHTML = '';

            for (const [category, tasks] of Object.entries(data)) {
                const categoryHeader = document.createElement('h3');
                categoryHeader.textContent = category;
                tasksContainer.appendChild(categoryHeader);

                const taskList = document.createElement('ul');

                tasks.forEach(task => {
                    const taskItem = document.createElement('li');
                    taskItem.textContent = task.name;
                    taskList.appendChild(taskItem);
                });

                tasksContainer.appendChild(taskList);
            }
        })
        .catch(error => console.error('Error fetching task data:', error));

    fetch('/projects')
        .then(response => response.json())
        .then(data => {
            const statuses = {
                CANCELED: 0,
                WAITING_DELIVERY: 0,
                DELIVERED: 0
            };

            data.forEach(project => {
                statuses[project.projectStatus]++;
            });

            const ctx = document.getElementById('taskChart').getContext('2d');
            const taskChart = new Chart(ctx, {
                type: 'pie',
                data: {
                    labels: ['Cancelado', 'Aguardando Entrega', 'Entregue'],
                    datasets: [{
                        data: [statuses.CANCELED, statuses.WAITING_DELIVERY, statuses.DELIVERED],
                        backgroundColor: ['#ff6961', '#fdfd96', '#77dd77']
                    }]
                },
                options: {
                    responsive: true
                }
            });
        })
        .catch(error => console.error('Error fetching project data:', error));
});
