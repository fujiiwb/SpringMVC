//    function autoResizeDiv() {
//        height = (document.body.clientHeight
//                 - document.getElementById('div-header').offsetHeight
//                 - document.getElementById('div-footer').offsetHeight
//                 - document.getElementById('menu-header').offsetHeight
////               - 15
//               ) +'px';
//        document.getElementById('div-left').style.height = height;
//        document.getElementById('div-right').style.height = height;
//        document.getElementById('browser').innerHTML =
//        document.documentElement.clientWidth + " x " + document.documentElement.clientHeight;
//    }
//    window.onresize = autoResizeDiv;
//    autoResizeDiv();
//
//    window.setInterval(
//        function updateServerTime() {
//            var date = new Date();
//            document.getElementById("servertime").innerHTML =
//                date.toLocaleTimeString() + " " + date.toLocaleDateString();
//        }, 1000
//    );