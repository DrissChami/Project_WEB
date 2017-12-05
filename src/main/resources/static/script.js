$(document).ready(function () {
    $.ajax({
        url: "localhost:8080/cars"
    }).then(function (data) {
        $('.test').append(data.platenumber);
        $('.test-content').append(data.brand);
    });
});
