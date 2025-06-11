<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">

<head>
    <title>Signup</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
    <script src="assets/js/color-modes.js"></script>
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<main class="form-signin w-100 m-auto">
    <form action="/signup" method="post">
        <img class="mb-4" src="logo.png" alt="" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal">Enter email, username, and password to Sign Up</h1>

        <#-- Show error message if present -->
        <#if error??>
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </#if>

        <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" name="email" placeholder="name@example.com" required>
            <label for="floatingInput">Email address</label>
        </div>

        <div class="form-floating">
            <input type="text" class="form-control" id="floatingUsername" name="username" placeholder="Username" required>
            <label for="floatingUsername">Username</label>
        </div>

        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password" required>
            <label for="floatingPassword">Password</label>
        </div>

        <button class="btn btn-primary w-100 py-2" type="submit">Sign Up</button>
        <br><br>
        <button onclick="location.href='/index'" class="btn btn-primary w-100 py-2" type="button">Returning User Sign In</button>
        <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2025</p>
    </form>
</main>

<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
