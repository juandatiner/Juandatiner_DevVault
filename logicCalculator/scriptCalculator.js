document.addEventListener('DOMContentLoaded', function() {
    // Elementos del DOM
    const result = document.getElementById('result');
    const scrollIndicatorLeft = document.querySelector('.scroll-indicator.left');
    const scrollIndicatorRight = document.querySelector('.scroll-indicator.right');
    const clearButton = document.querySelector('.clear-btn');
    const allButtons = document.querySelectorAll('.buttons button'); // Todos los botones
    const margin = 10; // Margen adicional para la sombra derecha

    // Actualización de indicadores de desplazamiento
    function updateScroll() {
        const hasHorizontalScroll = result.scrollWidth > result.clientWidth;
        const scrollLeft = result.scrollLeft;
        const scrollWidth = result.scrollWidth;
        const clientWidth = result.clientWidth;

        // Mostrar sombra izquierda si hay desplazamiento a la izquierda
        scrollIndicatorLeft.style.display = scrollLeft > 0 ? 'block' : 'none';

        // Mostrar sombra derecha si hay desplazamiento a la derecha
        scrollIndicatorRight.style.display = scrollLeft + clientWidth < scrollWidth - margin ? 'block' : 'none';
    }

    // Enfocar al final del contenido
    function focusEnd() {
        result.scrollLeft = result.scrollWidth;
    }

    // Deshabilitar todos los botones excepto el botón de borrar
    function disableAllButtonsExceptClear() {
        allButtons.forEach(button => {
            if (button !== clearButton) {
                button.disabled = true;
                button.style.opacity = '0.5';
                button.style.cursor = 'not-allowed'; // Cambia el cursor para indicar que el botón está deshabilitado
            }
        });
    }

    // Habilitar todos los botones
    function enableAllButtons() {
        allButtons.forEach(button => {
            if (button !== clearButton) {
                button.disabled = false;
                button.style.opacity = '1';
                button.style.cursor = 'pointer'; // Restablece el cursor
            }
        });
    }

    // Función para limpiar el resultado
    window.clearResult = function() {
        result.value = '';
        updateScroll(); // Llama a updateScroll después de limpiar el contenido
        focusEnd();
        enableAllButtons(); // Rehabilitar todos los botones después de limpiar
    }

    // Función para borrar el último carácter
    window.deleteLast = function() {
        result.value = result.value.slice(0, -1);
        updateScroll(); // Llama a updateScroll después de borrar el último carácter
        focusEnd();
    }

    // Función para agregar un valor al resultado
    window.appendValue = function(value) {
        const allowedMessages = ["Ingresa tu función", "Error", "Tautología", "Contradicción", "Contingencia"];
        if (allowedMessages.includes(result.value)) {
            result.value = '';
        }
        // Solo agrega valores válidos
        result.value += value;
        updateScroll(); // Llama a updateScroll después de agregar un nuevo valor
        focusEnd();
    }

    // Función para realizar una operación lógica
    window.performOperation = function(operation) {
        if (operation === 'NOT') {
            appendValue('¬');
        } else if (operationSymbols[operation]) {
            appendValue(operationSymbols[operation]);
        }
    }

    // Símbolos de operaciones lógicas
    const operationSymbols = {
        'AND': '∧',
        'OR': '∨',
        'IMPLIES': '→',  // Añadido símbolo de implicación
        'BICONDITIONAL': '↔'  // Añadido símbolo de doble implicación
    };

    function evaluateAllCombinations(expression) {
        const variables = Array.from(new Set(expression.match(/[a-zA-Z]/g)));
    
        if (variables.length === 0) {
            return [evaluateLogic(expression)];
        }
    
        const results = [];
        const numCombinations = Math.pow(2, variables.length);
    
        for (let i = 0; i < numCombinations; i++) {
            const combination = {};
            variables.forEach((variable, index) => {
                combination[variable] = Boolean(i & (1 << index));
            });
    
            const evalExpression = expression.replace(/[a-zA-Z]/g, match => combination[match]);
            const result = evaluateLogic(evalExpression);
            results.push(result);
        }
    
        return results;
    }

    // Eliminar paréntesis y corchetes vacíos
    function removeEmptyParenthesesAndBrackets(expression) {
        // Elimina los paréntesis y corchetes vacíos
        expression = expression.replace(/\(\s*\)/g, '');
        expression = expression.replace(/\[\s*\]/g, '');
        // También elimina los paréntesis o corchetes vacíos dentro de otros paréntesis o corchetes
        while (/\(\s*\)/g.test(expression) || /\[\s*\]/g.test(expression)) {
            expression = expression.replace(/\(\s*\)/g, '');
            expression = expression.replace(/\[\s*\]/g, '');
        }
        return expression;
    }

    function preprocessExpression(expression) {
        // Eliminar paréntesis y corchetes vacíos
        expression = removeEmptyParenthesesAndBrackets(expression);
        
        // Reemplaza los símbolos lógicos con sus equivalentes en JavaScript
        expression = expression.replace(/¬/g, '!');
        expression = expression.replace(/∧/g, '&&');
        expression = expression.replace(/∨/g, '||');
        expression = expression.replace(/→/g, '<='); // Implicación como <= para propósitos de evaluación
        expression = expression.replace(/↔/g, '==='); // Doble implicación como === para propósitos de evaluación

        return expression;
    }

    // Función para evaluar la lógica de la expresión con precedencia adecuada
    function evaluateLogic(expression) {
        try {
            // Evaluar expresiones dentro de paréntesis primero
            while (/\([^\(\)]*\)/.test(expression)) {
                expression = expression.replace(/\([^\(\)]*\)/g, match => {
                    return evaluateLogic(match.slice(1, -1)); // Quitar paréntesis y evaluar
                });
            }

            // Evaluar expresiones dentro de corchetes después
            while (/\[[^\[\]]*\]/.test(expression)) {
                expression = expression.replace(/\[[^\[\]]*\]/g, match => {
                    return evaluateLogic(match.slice(1, -1)); // Quitar corchetes y evaluar
                });
            }

            // Evaluar expresiones con precedencia lógica
            const preprocessedExpression = preprocessExpression(expression);
            console.log('Expresión preprocesada:', preprocessedExpression); // Depuración

            // Evaluar la expresión con precedencia
            return new Function('return ' + preprocessedExpression)();
        } catch (e) {
            console.error('Error en la evaluación de la expresión lógica:', e);
            return 'Error';
        }
    }

    // Función para manejar el botón igual
    function handleEqualButton() {
        const expression = result.value;

        // Verificar si la expresión contiene solo paréntesis o corchetes vacíos
        const isEmptyParenthesesOrBrackets = /^(\(\s*\)|\[\s*\])+$/.test(expression);

        if (expression.trim() === '' || isEmptyParenthesesOrBrackets) {
            result.value = 'Ingresa tu función';
        } else {
            const results = evaluateAllCombinations(expression);
            if (results.includes('Error')) {
                result.value = 'Error';
            } else if (results.every(result => result === true)) {
                result.value = 'Tautología';
            } else if (results.every(result => result === false)) {
                result.value = 'Contradicción';
            } else {
                result.value = 'Contingencia'; // Mezcla de valores verdaderos y falsos
            }
        }
        disableAllButtonsExceptClear(); // Deshabilitar todos los botones excepto el de borrar
    }

    // Asignar el manejador de eventos al botón igual
    document.querySelector('.equal-btn').addEventListener('click', handleEqualButton);

    // Evento de desplazamiento para actualizar las sombras
    result.addEventListener('scroll', updateScroll); // Asegúrate de que updateScroll se llame en el evento scroll
    updateScroll(); // Llama a updateScroll cuando la página se cargue
});


