document.addEventListener('DOMContentLoaded', function() {
    // Menu Toggle
    const menuToggle = document.getElementById('menu-toggle');
    const menu = document.getElementById('menu');

    menuToggle.addEventListener('click', function() {
        if (menu.style.display === 'none' || menu.style.display === '') {
            menu.style.display = 'flex';
        } else {
            menu.style.display = 'none';
        }
    });

    // Fetching data from API for tasks
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

    // Fetching data from API for orders
    fetch('/orders')
        .then(response => response.json())
        .then(data => {
            const statuses = {
                CANCELED: 0,
                WAITING_DELIVERY: 0,
                DELIVERED: 0
            };

            data.forEach(order => {
                statuses[order.orderStatus]++;
            });

            const ctx = document.getElementById('taskChart').getContext('2d');
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
        .catch(error => console.error('Error fetching order data:', error));
});