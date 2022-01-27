import NavbarListItem from "./components/NavbarListItem";


function Navbar() {
    return (
        <div>
            <div className="header-navbar">
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/ingredient">Add ingredient</a></li>
                    <li><a href="/create-recipe">Create recipe</a></li>
                    <li><a href="/create-customer">Add Customer</a></li>
                    <NavbarListItem url={"/create-order"} text={"Add new order"}/>
                    <NavbarListItem url={"/list-active-orders"} text={"Active orders"}/>
                    <li><a href="#">About</a></li>
                </ul>
            </div>
        </div>
)
}

export default Navbar;