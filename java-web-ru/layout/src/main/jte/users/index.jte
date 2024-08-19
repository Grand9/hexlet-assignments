@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(content = @`
    @if(page.getUsers().isEmpty())
        <p>There are no users at the moment</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <p>${user.getFirstName()} ${user.getLastName()}</p>
                <p>${user.getEmail()}</p>
            </div>
        @endfor
    @endif
`)
