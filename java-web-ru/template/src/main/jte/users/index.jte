@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>${page.getHeader()}</title>
</head>
<body>
<div class="container mt-4">
    <h1>${page.getHeader()}</h1>
    @if(page.getUsers().isEmpty())
        <p>Нет пользователей</p>
    @else
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Email</th>
                <th>Действие</th>
            </tr>
            </thead>
            <tbody>
            @for(user in page.getUsers())
                <tr>
                    <td>${user.getId()}</td>
                    <td><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></td>
                    <td>${user.getEmail()}</td>
                    <td><a href="/users/${user.getId()}" class="btn btn-primary">Просмотр</a></td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif
    <a href="/" class="btn btn-secondary">На главную</a>
</div>
</body>
</html>
