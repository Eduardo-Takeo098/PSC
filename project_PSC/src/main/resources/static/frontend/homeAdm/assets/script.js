// Adiciona um listener que será executado quando o conteúdo da página for completamente carregado.
document.addEventListener('DOMContentLoaded', function() {

    // Seleciona os elementos do DOM: o botão de alternância do menu e o próprio menu.
    const menuToggle = document.getElementById('menu-toggle');
    const menu = document.getElementById('menu');

    // Seleciona o botão para abrir o formulário de projeto, o modal do formulário e o botão de fechar o modal.
    const projectButton = document.getElementById('project-button');
    const projectFormModal = document.getElementById('project-form-modal');
    const closeModal = document.querySelector('.project-form-content .close');
    // Seleciona o formulário de projeto.
    const projectForm = document.getElementById('project-form');

    // Adiciona um listener ao botão de toggle do menu que alterna a exibição do menu.
    menuToggle.addEventListener('click', function() {
        if (menu.style.display === 'none' || menu.style.display === '') {
            menu.style.display = 'flex';
        } else {
            menu.style.display = 'none';
        }
    });

    // Adiciona um listener ao botão de projeto que exibe o modal do formulário de projeto e carrega as categorias.
    projectButton.addEventListener('click', function() {
        projectFormModal.style.display = 'block';
        loadCategories();
    });

    // Adiciona um listener ao botão de fechar modal que oculta o modal do formulário de projeto.
    closeModal.addEventListener('click', function() {
        projectFormModal.style.display = 'none';
    });

    // Adiciona um listener para fechar o modal se clicar fora dele.
    window.addEventListener('click', function(event) {
        if (event.target === projectFormModal) {
            projectFormModal.style.display = 'none';
        }
    });

    // Adiciona um listener ao formulário de projeto que será executado quando o formulário for submetido.
    projectForm.addEventListener('submit', function(event) {
        // Previna o comportamento padrão do formulário (que seria recarregar a página).
        event.preventDefault();

        // Obtém os valores dos campos do formulário.
        const taskName = document.getElementById('taskName').value;
        const taskDescription = document.getElementById('taskDescription').value;
        const taskUrlImg = document.getElementById('taskUrlImg').value;
        const categoryId = document.getElementById('categorySelect').value;

        // Cria um objeto com os dados da tarefa.
        const task = {
            taskName: taskName,
            taskDescription: taskDescription,
            taskUrlImg: taskUrlImg,
            categoryId: categoryId
        };

        // Faz uma requisição POST para o endpoint '/tasks' enviando os dados da tarefa em formato JSON.
        fetch('/tasks', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(task)
        })
            // Converte a resposta da requisição para JSON.
            .then(response => response.json())
            // Se a resposta for bem-sucedida, oculta o modal, reseta o formulário e exibe um alerta de sucesso.
            .then(data => {
                console.log('Success:', data);
                projectFormModal.style.display = 'none';
                projectForm.reset();
                alert('Projeto e tarefa criados com sucesso');
            })
            // Caso ocorra um erro na requisição, exibe um alerta de erro.
            .catch((error) => {
                console.error('Error:', error);
                alert('Erro ao criar projeto e tarefa. Por favor, tente novamente.');
            });
    });

    // Função que carrega as categorias para o select do formulário de projeto.
    function loadCategories() {
        // Faz uma requisição GET para o endpoint '/categories' para obter as categorias.
        fetch('/categories')
            .then(response => response.json())
            // Preenche o select com as categorias obtidas.
            .then(categories => {
                const categorySelect = document.getElementById('categorySelect');
                categorySelect.innerHTML = '';
                categories.forEach(category => {
                    const option = document.createElement('option');
                    option.value = category.id;
                    option.textContent = category.name;
                    categorySelect.appendChild(option);
                });
            })
            // Caso ocorra um erro na requisição, exibe um erro no console.
            .catch(error => console.error('Error fetching categories:', error));
    }

    // Faz uma requisição para obter as tarefas agrupadas por categoria.
    fetch('/tasks/groupedByCategory')
        .then(response => response.json())  // Converte a resposta da requisição para JSON.
        .then(data => {
            // Seleciona o contêiner onde as tarefas serão inseridas.
            const tasksContainer = document.querySelector('.section:nth-child(2) ul');
            tasksContainer.innerHTML = '';  // Limpa o contêiner de tarefas.

            // Itera sobre os dados recebidos, que estão agrupados por categoria.
            for (const [category, tasks] of Object.entries(data)) {
                // Cria e adiciona um cabeçalho para cada categoria.
                const categoryHeader = document.createElement('h3');
                categoryHeader.textContent = category;
                tasksContainer.appendChild(categoryHeader);

                // Cria uma lista para as tarefas da categoria.
                const taskList = document.createElement('ul');

                // Adiciona cada tarefa como um item na lista.
                tasks.forEach(task => {
                    const taskItem = document.createElement('li');
                    taskItem.textContent = task.name;
                    taskList.appendChild(taskItem);
                });

                // Adiciona a lista de tarefas ao contêiner de tarefas.
                tasksContainer.appendChild(taskList);
            }
        })
        // Caso ocorra um erro na requisição, exibe uma mensagem de erro no console.
        .catch(error => console.error('Error fetching task data:', error));

    // Faz uma requisição para obter os dados dos projetos.
    fetch('/projects')
        .then(response => response.json())  // Converte a resposta da requisição para JSON.
        .then(data => {
            // Inicializa um objeto para contar os status dos projetos.
            const statuses = {
                CANCELED: 0,
                WAITING_DELIVERY: 0,
                DELIVERED: 0
            };

            // Itera sobre os dados dos projetos e conta cada status.
            data.forEach(project => {
                statuses[project.projectStatus]++;
            });

            // Seleciona o contexto do canvas onde o gráfico será desenhado.
            const ctx = document.getElementById('taskChart').getContext('2d');
            // Cria um gráfico de pizza usando os dados de status dos projetos.
            const taskChart = new Chart(ctx, {
                type: 'pie',
                data: {
                    labels: ['Cancelado', 'Aguardando Entrega', 'Entregue'],
                    datasets: [{
                        data: [statuses.CANCELED, statuses.WAITING_DELIVERY, statuses.DELIVERED],
                        backgroundColor: ['#dc3545', '#ffc107', '#28a745']
                    }]
                },
                options: {
                    responsive: true
                }
            });
        })
        // Caso ocorra um erro na requisição, exibe uma mensagem de erro no console.
        .catch(error => console.error('Error fetching project data:', error));
});
