document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(event.target);

    const loginData = {};
    formData.forEach((value, key) => {
        loginData[key] = value;
    });

    fetch('/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Login bem sucedido!');
                window.location.href = '/home';
            } else {
                alert('Email ou senha incorretos. Tente novamente.');
            }
        })
        .catch(error => {
            console.error('Erro ao realizar login:', error);
            alert('Erro ao realizar login. Por favor, tente novamente.');
        });
});