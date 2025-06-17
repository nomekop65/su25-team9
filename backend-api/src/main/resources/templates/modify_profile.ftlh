<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify Profile</title>
    <link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2>Change Password</h2>
    <form method="post" action="/modify_profile">
        <div class="mb-3">
            <label>Email:</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Current Password:</label>
            <input type="password" name="currentPassword" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>New Password:</label>
            <input type="password" name="newPassword" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Update Password</button>
    </form>
</body>
</html>
