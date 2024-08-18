@import exercise.dto.users.UserPage
@param UserPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Пользователь</title>
</head>
<body>
<div class="container mt-4">
    <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
    <p>Email: ${page.getUser().getEmail()}</p>
    <a href="/users" class="btn btn-secondary">Назад к списку пользователей</a>
</div>
</body>
</html>
