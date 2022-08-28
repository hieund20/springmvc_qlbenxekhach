/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const generateColor = () => {
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r}, ${g}, ${b})`;
}

const garageChart = (id, garageLabels=[], garageInfo=[]) => {
    const data = {
        labels: garageLabels,
        datasets: [{
                label: 'Thống kê số lượng tuyến theo nhà xe',
                data: garageInfo,
                backgroundColor: [
                    'rgb(255, 99, 132)',
                    'rgb(54, 162, 235)',
                    'rgb(255, 205, 86)'
                ],
                hoverOffset: 4
            }]  
    };

    const config = {
        type: 'doughnut',
        data: data,
        options: {
            maintainAspectRatio: false
        }
    };
    
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
};

const routeChart = (id, routeLabels=[], routeInfo=[]) => {
    const data = {
        labels: routeLabels,
        datasets: [{
                label: 'Thống kê doanh thu theo từng tuyến',
                data: routeInfo,
                fill: false,
                borderColor: 'rgb(75, 192, 192)',
                tension: 0.1
            }]
    };

    const config = {
        type: 'line',
        data: data,
        options: {
            maintainAspectRatio: false
        }
    };
    
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

const routeMonthChart = (id, routeLabels = [], routeInfo = [], routeName = []) => {
    let colors = [];
    for (let i = 0; i < routeInfo.length; i++) {
        colors.push(generateColor());
    }

    const data = {
        labels: routeLabels,
        datasets: [{
                label: routeName,
                data: routeInfo,
                fill: false,
                backgroundColor: colors,
                borderColor: colors,
                borderWidth: 1
            }]
    };

    const config = {
        type: 'bar',
        data: data
    };
    
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}

const routeYearChart = (id, routeLabels = [], routeInfo = [], routeName = []) => {
    let colors = [];
    for (let i = 0; i < routeInfo.length; i++) {
        colors.push(generateColor());
    }

    const data = {
        labels: routeLabels,
        datasets: [{
                label: routeName,
                data: routeInfo,
                fill: false,
                backgroundColor: colors,
                borderColor: colors,
                borderWidth: 1
            }]
    };

    const config = {
        type: 'bar',
        data: data
    };
    
    let ctx = document.getElementById(id).getContext("2d");
    new Chart(ctx, config);
}
