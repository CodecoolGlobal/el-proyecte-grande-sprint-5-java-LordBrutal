import chef from "../images/logoChef.svg"

function Main(){
    return (
        <div>
            <h1>Welcome in the My Restaurant Application</h1>
            <h2>Choose some operation from the navigation bar!</h2>
            <div className="center-img">
                <img className="chef-logo" src={chef} alt=""/>
            </div>
        </div>
    )
}

export default Main