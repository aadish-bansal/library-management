<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Login</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
      crossorigin="anonymous"
    />
  </head>

  <body   class="container d-flex flex-column min-vh-100">
     <header class="row pt-3">
            <h2 class="text-center">Library management</h2>
          </header>
    <section class=" ">
      <form:form
      action="validate"
      cssClass="row "
      method="post"
      modelAttribute="loginCredentials"
    >
      <fieldset  class="border p-2 col-sm-8 mx-auto ">
        <legend class="float-none text-primary w-auto">Login</legend>
        <div class="row mb-3">
            <label for="uname" class="col-sm-2 offset-1 col-form-label">Username</label>
            <div class="col-sm-6">
              <form:input path="name" cssClass="form-control"  />
            </div>
            <form:errors path="name" cssClass="col-lg-3" />

          </div>
        <div class="row mb-3">
          <label for="upass" class="col-sm-2 offset-1 col-form-label">Password</label>
          <div class="col-sm-6">
              <form:password path="password"  cssClass="form-control"/>
          </div>
          <form:errors path="password" cssClass="col-lg-3" />
          </div>
          <div class="row">
            <div class="col-lg-6  mx-auto">
                <button class="btn btn-outline-primary" type="submit">
                  Login
                </button>
            </div>
          </div>
      </fieldset>
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
