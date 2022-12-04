<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard | Squawk!</title>
        <link rel="stylesheet" href="./css/a-style.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp"
              rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.js"></script>
        <style>
            #chart-wrapper {
                width: 65%;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <!-- SIDEBAR AND HEADER -->
            <jsp:include page="WEB-INF/pages/dashboard/commons/sidebar-header.jsp"/>
            <main>
                <h1>Dashboard</h1>

                <div class="insights">
                    <div class="sales">
                        <span class="material-icons-sharp">markunread_mailbox</span>
                        <div class="middle">
                            <div class="left">
                                <h3>Cuacks Publicados</h3>
                                <h1>6</h1>
                            </div>
                            <div class="progress">
                                <svg>
                                <circle cx='38' cy='38' r='36'></circle>
                                </svg>
                                <div class="number">
                                    <p><b>100%</b></p>
                                </div>
                            </div>
                        </div>
                    </div>     
                    <!-----END OF SALES-------->    
                    <div class="expenses">
                        <span class="material-icons-sharp">group</span>
                        <div class="middle">
                            <div class="left">
                                <h3>Usuarios Normales</h3>
                                <h1>3</h1>
                            </div>
                            <div class="progress">
                                <svg>
                                <circle cx='38' cy='38' r='36'></circle>
                                </svg>
                                <div class="number">
                                    <p><b>30%</b></p>
                                </div>
                            </div>
                        </div>
                    </div>     
                    <!-----END OF EXPENSES-------->   
                    <div class="income">
                        <span class="material-icons-sharp">workspace_premium</span>
                        <div class="middle">
                            <div class="left">
                                <h3>Usuarios Premium</h3>
                                <h1>3</h1>
                            </div>
                            <div class="progress">
                                <svg>
                                <circle cx='38' cy='38' r='36'></circle>
                                </svg>
                                <div class="number">
                                    <p><b>30%</b></p>
                                </div>
                            </div>
                        </div>
                    </div>     
                    <!-----END OF INCOME-------->       
                </div>
                <!-----END OF INSIGHTS-------->       

                <div class="recent-orders">
                    <h2>Estadisticas</h2>
                    <table>
                        <tr>
                            <th>
                                <div id="chart-wrapper">
                                    <canvas id="myChart"></canvas>
                                </div>
                            </th>
                            <th>
                                <div id="chart-wrapper">
                                    <canvas id="Chart"></canvas>
                                </div>
                            </th>
                        </tr>
                    </table>
                    <script>
                    <jsp:include page="/WEB-INF/pages/user/commons/icon.jsp"/>
                        var ctx = document.getElementById("myChart").getContext("2d");
                        var myChart = new Chart(ctx, {
                            type: "line",
                            data: {
                                labels: ['OCT', 'NOV',<c:forEach items="${cantUser}" var="c">${c.mes}</c:forEach>],
                                datasets: [{

                                        label: 'Usuarios x Mes',
                                        data: [62, 87],
                                        fill: false,
                                        backgroundColor: 'rgb(120, 146, 250)',
                                        borderColor: 'rgb(120, 146, 250)',
                                        tension: 0.1
                                    }]
                            },
                            options: {
                                plugins: {
                                    legend: {
                                        ticks: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            }
                        });

                        var ctx = document.getElementById("Chart").getContext("2d");
                        var Chart = new Chart(ctx, {
                            type: "line",
                            data: {
                                labels: ['OCT', 'NOV'

                                ],
                                datasets: [{

                                        label: 'Cuacks x Mes',
                                        data: [56, 37
                                        ],
                                        fill: false,
                                        backgroundColor: 'rgb(120, 250, 202)',
                                        borderColor: 'rgb(120, 250, 202)',
                                        tension: 0.1
                                    }]
                            },
                            options: {
                                plugins: {
                                    legend: {
                                        ticks: {
                                            beginAtZero: true
                                        }
                                    }
                                }
                            }
                        });
                    </script>
                </div>
            </main>
            <!-----------EN OF MAIN--------->

            <div class="right">
                <jsp:include page="WEB-INF/pages/dashboard/commons/profile-dark-mode.jsp"/>
                <!----------END OF TOP---------->
                <div class="recent-updates">
                    <h2>Miembros de Squawk!</h2>
                    <div class="updates">
                        <div class="update">
                            <div class="profile-photo">
                                <img src=".//images/joseph.jpg">
                            </div>
                            <div class="message">
                                <p>Joseph Gianfranco <b>Cavero Ramos</b></p>
                                <small class="text-muted">Ingeniero de Sistemas e Inform&aacute;tica</small>
                            </div>
                        </div>
                        <div class="update">
                            <div class="profile-photo">
                                <img src=".//images/juan.jpg">
                            </div>
                            <div class="message">
                                <p>Juan Jos&eacute; <b>De La Portilla C&aacute;rdenas</b></p>
                                <small class="text-muted">Ingeniero de Software</small>
                            </div>
                        </div>
                        <div class="update">
                            <div class="profile-photo">
                                <img src=".//images/sindell.jpg">
                            </div>
                            <div class="message">
                                <p>Sindell Lilian <b>Leon Paucar</b></p>
                                <small class="text-muted">Ingeniera de Sistemas e Inform&aacute;tica</small>
                            </div>
                        </div>
                        <div class="update">
                            <div class="profile-photo">
                                <img src=".//images/gian.jpg">
                            </div>
                            <div class="message">
                                <p>Gianpierre Javier <b>Vargas Carrasco</b></p>
                                <small class="text-muted">Ingeniero de Software</small>
                            </div>
                        </div>
                    </div>
                </div>
                <!-------END OF RECENT UPDATES
                <div class="sales-analytics">
                    <h2>Sales Analytics</h2>
                    <div class="item online">
                        <div class="icon">
                            <span class="material-icons-sharp">shopping_cart</span>
                        </div>
                        <div class="right">
                            <div class="info">
                                <h3>ONLINE ORDERS</h3>
                                <small class="text-muted">Last 24 Hours</small>
                            </div>
                            <h5 class="success">+39%</h5>
                            <h3>3849</h3>
                        </div>
                    </div>
                    <div class="item offline">
                        <div class="icon">
                            <span class="material-icons-sharp">local_mall</span>
                        </div>
                        <div class="right">
                            <div class="info">
                                <h3>OFFLINE ORDERS</h3>
                                <small class="text-muted">Last 24 Hours</small>
                            </div>
                            <h5 class="danger">-17%</h5>
                            <h3>1100</h3>
                        </div>
                    </div>
                    <div class="item customers">
                        <div class="icon">
                            <span class="material-icons-sharp">person</span>
                        </div>
                        <div class="right">
                            <div class="info">
                                <h3>NEW CUSTOMERS</h3>
                                <small class="text-muted">Last 24 Hours</small>
                            </div>
                            <h5 class="success">+25%</h5>
                            <h3>849</h3>
                        </div>
                    </div>
                    <div class="item add-product">
                        <div>
                            <span class="material-icons-sharp">add</span>
                            <h3>Add Product</h3>
                        </div>
                    </div>
                </div>
                --------->
            </div>
        </div>

        <script src="./js/users.js?v=1"></script>
        <script src="./js/white-theme.js"></script>
    </body>
</html>