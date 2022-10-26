<%@ page isELIgnored="false" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <%@ page
import="java.util.List" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Books</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
      crossorigin="anonymous"
    />
  </head>
  <body class="container-fluid d-flex flex-column min-vh-100">
  <% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
   if(session.getAttribute("loginData")==null){
    response.sendRedirect("login");
    }
    %>
      <header class="row pt-3">
        <h2 class="col-lg-7 text-end">Library management</h2>
        <div class="col-lg-5 text-end">
          <span class="mx-3">Welcome ${loginData.name} </span>
          <a href="logout" class="btn btn-outline-primary mx-3">Logout </a>
        </div>
      </header>
      <section class="row">
        <div class="row  mt-5  ">
           <div class="col-6 text-end">
             <h3>Books Listing</h3>
           </div>
           <div class="col-6 text-end">
             <a class="btn btn-primary" href="formForAdd" role="button">Add a book</a>
          </div>
        </div>

        <c:choose>
      <c:when test="${fn:length(bookList)!=0}">
      <div class="row mt-5" >
         <div class="col-lg-11 mx-auto ">
                <table class="table table-bordered ">
                  <thead class="text-center">
                    <tr>
                      <td>Book Code</td>
                      <td>Book Name</td>
                      <td>Author</td>
                      <td>Data Added</td>
                      <td>Actions</td>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="tempList" items="${bookList}">
                      <tr class="text-center ">
                      <td>${tempList.getId()}</td>
                      <td>${tempList.getName()}</td>
                        <td>${tempList.getAuthor().getName()}</td>

                      <td>${tempList.getDate()}</td>
                      <td>
                        <a href="formForUpdate/${tempList.getId()}" class="btn btn-outline-secondary ">Edit </a>
                        <a href="delete/${tempList.getId()}" class="btn btn-outline-danger ">Delete </a>
                      </td>
                      <tr>
                      </c:forEach>
                  </tbody>
                </table>
              </div>
              </div>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
      </section>
      <footer class="mt-auto">
        <h4 class="text-center">Our social media handles</h4>
      </footer>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
