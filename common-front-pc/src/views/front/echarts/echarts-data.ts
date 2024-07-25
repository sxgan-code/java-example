export const pieData = {
    series: [
        {
            type: 'pie',
            data: [
                {value: 1, name: 'Java案例'},
                {value: 7, name: '组件'},
                {value: 1, name: 'CSS案例'},
                {value: 1, name: '前端案例'}
            ]
        }
    ]
}
export const histogramData = {
    xAxis: {
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {},
    series: [
        {
            type: 'bar',
            data: [23, 24, 18, 25, 27, 28, 25]
        }
    ]
};
export const multiColumnHistogramData = {
    xAxis: {
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {},
    series: [
        {
            type: 'bar',
            data: [23, 24, 18, 25, 27, 28, 25]
        },
        {
            type: 'bar',
            data: [26, 24, 18, 22, 23, 20, 27]
        }
    ]
};
export const polylineData = {
    xAxis: {
        type: 'category',
        data: ['A', 'B', 'C']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            data: [120, 200, 150],
            type: 'line'
        }
    ]
};

export const ringData = {
    title: {
        text: '圆环图',
        left: 'center',
        top: 'center'
    },
    series: [
        {
            type: 'pie',
            data: [
                {
                    value: 335,
                    name: 'A'
                },
                {
                    value: 234,
                    name: 'B'
                },
                {
                    value: 1548,
                    name: 'C'
                }
            ],
            radius: ['40%', '70%']
        }
    ]
};

export const nightingaleData = {
    series: [
        {
            type: 'pie',
            data: [
                {
                    value: 100,
                    name: 'A'
                },
                {
                    value: 200,
                    name: 'B'
                },
                {
                    value: 300,
                    name: 'C'
                },
                {
                    value: 400,
                    name: 'D'
                },
                {
                    value: 500,
                    name: 'E'
                }
            ],
            roseType: 'area'
        }
    ]
};

export const scatterPointData = {
    xAxis: {
        data: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
    },
    yAxis: {},
    series: [
        {
            type: 'scatter',
            data: [220, 182, 191, 234, 290, 330, 310]
        }
    ]
};

export const regionAreaData = {
    xAxis: {
        data: ['A', 'B', 'C', 'D', 'E']
    },
    yAxis: {},
    series: [
        {
            data: [10, 22, 28, 23, 19],
            type: 'line',
            areaStyle: {}
        },
        {
            data: [25, 14, 23, 35, 10],
            type: 'line',
            areaStyle: {
                color: '#ff0',
                opacity: 0.5
            }
        }
    ]
};

export const stackedPolylineData = {
    xAxis: {
        data: ['A', 'B', 'C', 'D', 'E']
    },
    yAxis: {},
    series: [
        {
            data: [10, 22, 28, 43, 49],
            type: 'line',
            stack: 'x'
        },
        {
            data: [5, 4, 3, 5, 10],
            type: 'line',
            stack: 'x'
        }
    ]
};