<%@include file="/WEB-INF/Views/jspf/header.jspf" %>

<h3>New user registration form</h3>
<hr>

<form  method="POST">

    <div class="form-group row">
        <label for="name" class="col-md-4">Name</label>
        <div class="col-md-8">
            <input type="text" placeholder="Name" class="form-control" name="name" id="name">
            <div class="text-danger">${errors.name}</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="email" class="col-md-4">Email address</label>
        <div class="col-md-8">
            <input type="email" placeholder="email@gmail.com" class="form-control" name="email" id="email">
            <div class="text-danger">${errors.email}</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="password" class="col-md-4">Password</label>
        <div class="col-md-8">
            <input type="password" placeholder="Password" class="form-control" name="password" id="password">
            <div class="text-danger">${errors.password}</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="c_password" class="col-md-4">Re-enter password</label>
        <div class="col-md-8">
            <input type="password" placeholder="Password" class="form-control" name="c_password" id="c_password">
            <div class="text-danger">${errors.cPassword}</div>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-md-4"></label>
        <div class="col-md-8">
            <button class="btn btn-primary">Register</button>
            <input type="reset" class="btn btn-link" value="Reset">
        </div>
    </div>

</form>

<%@ include file="/WEB-INF/Views/jspf/footer.jspf" %>
