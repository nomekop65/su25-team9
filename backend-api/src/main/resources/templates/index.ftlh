<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">

<head>
    <title>Sign In · Bootstrap v5.3</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
    <script src="assets/js/color-modes.js"></script>
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<main class="form-signin w-100 m-auto">
    <form action="/login" method="post">
        <img class="mb-4" src="logo.png" alt="" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" name="email" placeholder="name@example.com" required>
            <label for="floatingInput">Email address</label>
        </div>

        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password" required>
            <label for="floatingPassword">Password</label>
        </div>

        <div class="form-check text-start my-3">
            <input class="form-check-input" type="checkbox" value="remember-me" id="checkDefault" name="rememberMe">
            <label class="form-check-label" for="checkDefault">Remember me</label>
        </div>

        <button class="btn btn-primary w-100 py-2" type="submit">Sign In</button>
        <br><br>
        <button onclick="location.href='/signup'" class="btn btn-primary w-100 py-2" type="button">New User Sign Up</button>
        <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2025</p>
    </form>
</main>

<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
