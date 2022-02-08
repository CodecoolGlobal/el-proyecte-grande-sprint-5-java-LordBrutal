import React, {useState} from "react";
import "../collapsible.css"

function Collapsible(props) {
    const [isOpen, setIsOpen] = useState(false);

    return (
        <div className="collapsible">
            <div className="collapsible-header">
                <h1 className={"user-name"}>{props.content}</h1>

                <button className="toggle" onClick={() => setIsOpen(!isOpen)}>Open</button>
            </div>
            {isOpen && <div className="content">{props.children}</div>}
        </div>
    );
}

export default Collapsible;