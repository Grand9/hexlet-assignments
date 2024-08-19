@import exercise.dto.users.UsersPage
@param UsersPage page

<form action="/courses" method="get">
    <input type="search" name="term" value="${page.getTerm()}" />
    <input type="submit" value="Поиск" />
</form>

@template.layout.page(
content = @`

    @for(var user : page.getUsers())
        <div>
            <h2>${user.getFirstName() + " " + user.getLastName()}</h2>
            <p>${user.getEmail()}</p>
        </div>
    @endfor

`
)