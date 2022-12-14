<%-- 
   
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
       <div class="header-bottom">			
                    <div class="logo">
                        <a href="home"><img src="https://xxivstore.com/wp-content/themes/yootheme/cache/XXIV-Logo-Web-da8bec8c.webp" alt=" " ></a>
                    </div>

                    <div class="clearfix"> </div>
                </div>	
        <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
            >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="home">Home</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="gioithieu.jsp">Giới thiệu</a>
                </li>
                
                
                <c:if test="${sessionScope.account.isAdmin ==1 }">
               <li class="nav-item dropdown">
                    <a
                        class="nav-link dropdown-toggle"
                        id="navbarDropdown"
                        href="#"
                        role="button"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                        >Admin Shop</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="manager">Management Products</a></li>
                         <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="account">Management Account </a></li>
                         <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="totail">Order placed</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="listshipping">List Shipping</a></li>
                        
                    </ul>
                </li>
                     </c:if>
                 
            </ul>
          
            <div class="d-flex my-2">
                <a class="btn btn-outline-dark" href="carts">
                    <i class="bi-cart-fill me-1"></i>
                    Cart
                    <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.carts.size()}</span>
                </a>
            </div>
            <c:choose>
                <c:when test="${sessionScope.account !=null}">
                    <button class="btn btn-outline-primary ms-lg-2" ><a href="thongtintk.jsp" >${sessionScope.account.displayName}</a></button>  
                    <a href="logout" class="btn btn-outline-primary ms-lg-2" >Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="login" class="btn btn-outline-primary ms-lg-2" >Login</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>