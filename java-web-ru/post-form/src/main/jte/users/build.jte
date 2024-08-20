<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>
<h1>Create New User</h1>
<form action="/users" method="post">
    <div>
        <label>
            First Name
            <input type="text" name="firstName" required />
        </label>
    </div>
    <div>
        <label>
            Last Name
            <input type="text" name="lastName" required />
        </label>
    </div>
    <div>
        <label>
            Email
            <input type="email" name="email" required />
        </label>
    </div>
    <div>
        <label>
            Password
            <input type="password" name="password" required />
        </label>
    </div>
    <div>
        <label>
            Confirm Password
            <input type="password" name="passwordConfirmation" required />
        </label>
    </div>
    <input type="submit" value="Register" />
</form>
</body>
</html>
