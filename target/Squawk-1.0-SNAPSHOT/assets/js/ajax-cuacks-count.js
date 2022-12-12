(async () => {
    const respuestRaw = await fetch("dashboard?action=sendCuacks")
    const respuesta = await respuestRaw.json()
    const $grafica = document.querySelector('#cuacks')
    const etiquetas = respuesta[0]
    const arrayNumeros = respuesta[1]
    const datos = {
        labels: etiquetas,
        datasets: [{
            label: "Cuacks Registrados Por Mes",
            data: arrayNumeros,
            fill: false,
            backgroundColor: 'rgb(120, 250, 202)',
            borderColor: 'rgb(120, 250, 202)',
            tension: 0.1,
            borderWidth: 1
        }]
    }
    new Chart($grafica, {
        type: 'line',
        data: datos
    })
})();