function Button(props) {
    return (
        <button className={props.className}><a href={props.url}>{props.text}</a></button>
    );
}

export default Button;