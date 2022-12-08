(async () =>{
    const respuestRaw = await fetch("/Avance_Squawk_Maven/dashboard?action=sendUsers")
    const respuesta = await respuestRaw.json()
    const $grafica = document.querySelector('#users')
    const etiquetas = respuesta[0]
    const arrayNumeros = respuesta[1]
    const datos = {
        labels: etiquetas,
        datasets: [{
            label: "Usuarios Registrados Por Mes",
            data: arrayNumeros
        }]
    }
    new Chart($grafica, {
        type: 'bar',
        data: datos,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        },
    })
})();