(async () => {
    const respuestRaw = await fetch("dashboard?action=sendUsers")
    const respuesta = await respuestRaw.json()
    const $grafica = document.querySelector('#users')
    const etiquetas = respuesta[0]
    const arrayNumeros = respuesta[1]
    const datos = {
        labels: etiquetas,
        datasets: [{
            label: "Usuarios Registrados Por Mes",
            data: arrayNumeros,
            fill: false,
            backgroundColor: 'rgb(120, 146, 250)',
            borderColor: 'rgb(120, 146, 250)',
            tension: 0.1,
            borderWidth: 1
        }]
    }
    new Chart($grafica, {
        type: 'line',
        data: datos
    })
})();