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
    <title>Edit</title>
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
        response.sendRedirect("/LibraryManagement/login");
        }
        %>
    <header class="row pt-3">
      <h2 class="col-lg-7 text-end">Library management</h2>
      <div class="col-lg-5 text-end">
        <span class="mx-3">Welcome ${loginData.name} </span>
        <a href="/LibraryManagement/logout" class="btn btn-outline-primary mx-3">Logout </a>
      </div>
    </header>
    <section class="contatiner row mt-5">
      <div class="row">
        <h3 class="col-7 text-end">Edit Book Details</h3>
      </div>
      <form:form action="validate-update-books" cssClass="row mt-5" modelAttribute="book" method="post">
        <div class="row mb-3">
          <label for="lCode" class="col-sm-2 offset-1 col-form-label"
            >Book Code</label
          >
          <div class="col-sm-6">
            <form:input path="code" cssClass="form-control" readonly="true" />
          </div>
          <form:errors path="code" cssClass="col-lg-3" />
        </div>
        <div class="row mb-3">
          <label for="lName" class="col-sm-2 offset-1 col-form-label"
            >Book Name</label
          >
          <div class="col-sm-6">
            <form:input path="name" cssClass="form-control" />
          </div>
          <form:errors path="name" cssClass="col-lg-3" />
        </div>
        <div class="row mb-3">
          <label for="lAuthor" class="col-sm-2 offset-1 col-form-label"
            >Author
          </label>
          <div class="col-sm-6">
             <form:select path="author" cssClass="form-select">
                 <form:options items="${book.authorNameOptions}"/>
             </form:select>
           </div>
           <form:errors path="author" cssClass="col-lg-3" />
        </div>

        <div class="row mb-3">
          <label for="lAddedOn" class="col-sm-2 offset-1 col-form-label"
            >Added On</label
          >
          <div class="col-sm-6">
            <form:input
              path="addedDate"
              cssClass="form-control"
              readonly="true"
            />
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-lg-6 offset-1">
            <button class="col-lg-1 btn btn-primary" type="submit">
              Submit
            </button>
            <button class="col-lg-1 btn btn-danger" type="reset">
              Cancel
            </button>
          </div>
        </div>
      </form:form>
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
