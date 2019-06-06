var cart = [];

$(document).ready(function () {
    // Kiểm tra nếu đã có sessionStorage["shopping-cart-items"] hay chưa?
    if (sessionStorage["shopping-cart-items"] != null) {
        cart = JSON.parse(sessionStorage["shopping-cart-items"].toString());
    }

    // Hiển thị thông tin từ giỏ hàng
    displaycart();
});


// Sự kiện click các button có class=".add-to-cart"
$(".add-to-cart").click(function () {
    var button = $(this); // Lấy đối tượng button mà người dùng click
    var id = button.attr("id"); // id của sản phẩm là id của button
    var name = button.attr("data-name"); // name của sản phẩm là thuộc tính data-name của button
    var price = button.attr("data-price"); // price của sản phẩm là thuộc tính data-price của button
    var quantity = 1; // Số lượng
    var imageurl = button.attr("data-imageurl");


    var item = {
        id: id,
        name: name,
        price: price,
        quantity: quantity,
        imageurl: imageurl
    };

    var exists = false;
    if (cart.length > 0) {
        $.each(cart, function (index, value) {
            // Nếu mặt hàng đã tồn tại trong giỏ hàng thì chỉ cần tăng số lượng mặt hàng đó trong giỏ hàng.
            if (value.id == item.id) {
                value.quantity++;
                exists = true;
                return false;
            }
        });
    }

    // Nếu mặt hàng chưa tồn tại trong giỏ hàng thì bổ sung vào mảng
    if (!exists) {
        cart.push(item);
    }

    // Lưu thông tin vào sessionStorage
    sessionStorage["shopping-cart-items"] = JSON.stringify(cart); // Chuyển thông tin mảng cart sang JSON trước khi lưu vào sessionStorage
    // Gọi hàm hiển thị giỏ hàng
    displaycart();
});

// Xóa hết giỏ hàng cart
$("#button-clear").click(function () {
    cart = [];
    sessionStorage["shopping-cart-items"] = JSON.stringify(cart);
    $("#table-products > tbody").html("");
});

$("#span-cart").text("0");




// Hiển thị giỏ hàng ra table
function displaycart() {
    if (sessionStorage["shopping-cart-items"] != null) {
        cart = JSON.parse(sessionStorage["shopping-cart-items"].toString()); // Chuyển thông tin từ JSON trong sessionStorage sang mảng cart.


        var sum = 0;

        var total =0;
        $.each(cart,function(index,item) {
            sum+=item.quantity;
        });
        $("#span-cart").text(sum);

        $("#table-products > tbody").html("");
        // Duyệt qua mảng cart để append từng item dòng vào table
        $.each(cart, function (index, item) {
            var htmlString = "";
            htmlString += "<tr>";
            htmlString += "<td> <img src='" + item.imageurl + "'></td>";
            htmlString += "<td>" + item.name + "</td>";
            htmlString += "<td style='text-align: left'>" + item.price + "</td>";
            htmlString += "<td style='text-align: left'>" + item.quantity + "</td>";
            htmlString += "<td style='text-align: left'>$" + item.price * item.quantity + "</td>";
            htmlString += "</tr>";
            total+= item.price * item.quantity;
            $("#table-products > tbody:last").append(htmlString);

        });
        $("#span-total").text(total);
    }
}