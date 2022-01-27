function NavbarListItem(props) {
    return (
        <li><a href={props.url}>{props.text}</a></li>
    );
}

export default NavbarListItem;