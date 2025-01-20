// Mostrar alerta
function showAlert() {
    alert("Button clicked!");
}

// Función de cálculo
function Calcular(){
    // Obtener valores
    const numero1 = parseFloat(document.querySelector('#num1').value);
    const numero2 = parseFloat(document.querySelector('#num2').value);
    const oper = document.querySelector('#oper').value;

    // Validar que los números sean válidos
    if (isNaN(numero1) || isNaN(numero2)) {
        alert(`Error: numero invalido`);
        return; // Detener ejecución si los valores no son válidos
    }

    // Validar si no se seleccionó una operación
    if (!oper) {
        alert(`Error: la operacion no es valida seleccione otra`);
        return; // Detener ejecución si no hay operación seleccionada
    }

    // Realizar la operación
    let resultado;
    switch (oper) {
        case "sum":
            resultado = numero1 + numero2;
            alert(`El resultado es: `+resultado);
            break;
        case "res":
            resultado = numero1 - numero2;
            alert(`El resultado es: `+resultado);
            break;
        case "mul":
            resultado = numero1 * numero2;
            alert(`El resultado es: `+resultado);
            break;
        case "div":
            if (numero2 === 0) {
                alert(`Error: no se puede dividir entre 0`);
                return; // Detener ejecución si se intenta dividir entre cero
            }
            resultado = numero1 / numero2;
            alert(`El resultado es:`+resultado);
            break;
        default:
            alert(`Error: la operacion no es valida`);

            return; // Detener ejecución si no hay operación válida
    }
};

