document.addEventListener('DOMContentLoaded', function() {
    const playersTable = document.getElementById('players-table').getElementsByTagName('tbody')[0];
    const winnersTable = document.getElementById('winners-table').getElementsByTagName('tbody')[0];
    const playerNameInput = document.getElementById('player-name');
    const addPlayerButton = document.getElementById('add-player');
    const startGameButton = document.getElementById('start-game');
    const winnerNotification = document.getElementById('winner-notification');
    const winnerMessage = document.getElementById('winner-message');
    const fireworksCanvas = document.getElementById('fireworks-canvas');

    let players = [];

    function generateRandomCard() {
        return Math.floor(Math.random() * 10000);
    }

    function generateRandomIP() {
        return `${Math.floor(Math.random() * 256)}.${Math.floor(Math.random() * 256)}.${Math.floor(Math.random() * 256)}.${Math.floor(Math.random() * 256)}`;
    }

    function addPlayer() {
        const name = playerNameInput.value.trim();
        if (name && !players.some(player => player.name === name)) {
            const player = { name: name, card: generateRandomCard(), ip: generateRandomIP() };
            players.push(player);
            updatePlayersTable();
            playerNameInput.value = '';
        } else {
            alert('Nombre ya existe o está vacío');
        }
    }

    function startGame() {
        if (players.length > 0) {
            const randomIndex = Math.floor(Math.random() * players.length);
            const winner = players[randomIndex];
            updateWinnersTable(winner);
            showWinnerNotification(winner);
            // Actualiza los números de cartón para todos los jugadores
            players.forEach(player => player.card = generateRandomCard());
            updatePlayersTable();
        } else {
            alert('No hay jugadores para seleccionar');
        }
    }

    function updatePlayersTable() {
        playersTable.innerHTML = '';
        players.forEach((player, index) => {
            const row = playersTable.insertRow();
            row.insertCell().textContent = player.name;
            row.insertCell().textContent = player.card;
            row.insertCell().textContent = player.ip;
            const actionsCell = row.insertCell();
            actionsCell.innerHTML = `
                <button class="icon-button" onclick="editPlayer(${index})">✎</button>
                <button class="icon-button" onclick="removePlayer(${index})">🗑️</button>
                <button class="icon-button" onclick="refreshCard(${index})">🔄</button>
            `;
        });
    }

    function updateWinnersTable(winner) {
        const row = winnersTable.insertRow();
        row.insertCell().textContent = winner.name;
        row.insertCell().textContent = winner.card;
    }

    function showWinnerNotification(winner) {
        winnerMessage.textContent = `¡Felicidades ${winner.name}! Has ganado.`;
        winnerNotification.style.display = 'flex';

        // Oculta la notificación después de 5 segundos
        setTimeout(() => {
            winnerNotification.style.display = 'none';
        }, 5000);

        // Inicia la animación de fuegos artificiales
        startFireworks();
    }

    function startFireworks() {
        const ctx = fireworksCanvas.getContext('2d');
        const fireworks = [];

        fireworksCanvas.width = window.innerWidth;
        fireworksCanvas.height = window.innerHeight;

        function drawFireworks() {
            ctx.clearRect(0, 0, fireworksCanvas.width, fireworksCanvas.height);
            fireworks.forEach(firework => {
                firework.update();
                firework.draw(ctx);
            });
        }

        function updateFireworks() {
            if (Math.random() < 0.05) {
                fireworks.push(new Firework());
            }
            drawFireworks();
            requestAnimationFrame(updateFireworks);
        }

        updateFireworks();
    }

    class Firework {
        constructor() {
            this.x = Math.random() * fireworksCanvas.width;
            this.y = fireworksCanvas.height;
            this.size = Math.random() * 5 + 5;
            this.speed = Math.random() * 5 + 3;
            this.color = 'hsl(' + Math.random() * 360 + ', 100%, 50%)';
            this.gravity = 0.05;
        }

        update() {
            this.y -= this.speed;
            this.speed -= this.gravity;
            if (this.speed < 0) {
                this.size -= 0.1;
                if (this.size < 0) {
                    fireworks.shift();
                }
            }
        }

        draw(ctx) {
            ctx.beginPath();
            ctx.arc(this.x, this.y, this.size, 0, 2 * Math.PI);
            ctx.fillStyle = this.color;
            ctx.fill();
        }
    }

    // Event listeners
    addPlayerButton.addEventListener('click', addPlayer);
    startGameButton.addEventListener('click', startGame);

    // Funciones globales para editar, eliminar jugadores y actualizar cartones
    window.editPlayer = function(index) {
        const newName = prompt('Ingrese el nuevo nombre:', players[index].name);
        if (newName && !players.some(player => player.name === newName)) {
            players[index].name = newName;
            updatePlayersTable();
        } else {
            alert('Nombre ya existe o está vacío');
        }
    }

    window.removePlayer = function(index) {
        players.splice(index, 1);
        updatePlayersTable();
    }

    window.refreshCard = function(index) {
        players[index].card = generateRandomCard();
        updatePlayersTable();
    }
});
