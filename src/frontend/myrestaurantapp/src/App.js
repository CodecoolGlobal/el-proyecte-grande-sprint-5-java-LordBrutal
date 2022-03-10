import React from "react";
import Main from "./pages/Main";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import "./App.css"
import Navbar from "./Navbar";
import Ingredients from "./pages/Ingredients";
import CreateRecipe from "./pages/CreateRecipe";
import AddCustomer from "./pages/AddCustomer";
import AddNewOrder from "./pages/AddNewOrder";
import ActiveOrders from "./pages/ActiveOrders";
import Login from "./pages/Login";
import PageNotFound from "./pages/PageNotFound";
import {validateRoleAdmin, validateRoleUser} from "./services/UserRolesValidation";
import Storage from "./pages/Storage";
import RegisterUser from "./pages/RegisterUser";

function App() {
    return (
        <Router>
            <div className="App">
                <Navbar/>
                <Routes>
                    <Route path="/" element={<Main/>} exact/>
                    {validateRoleUser() && <Route path="/ingredient" element={<Ingredients/>}/>}
                    {validateRoleUser() && <Route path="/storage" element={<Storage/>}/>}
                    {validateRoleUser() && <Route path="/create-recipe" element={<CreateRecipe/>}/>}
                    {validateRoleUser() && <Route path="/create-customer" element={<AddCustomer/>}/>}
                    {validateRoleUser() && <Route path={"/create-order"} element={<AddNewOrder/>}/>}
                    {validateRoleUser() && <Route path="/list-active-orders" element={<ActiveOrders/>}/>}
                    {validateRoleAdmin() && <Route path="/register-user" element={<RegisterUser/>}/>}
                    <Route path="/login" element={<Login/>}/>
                    <Route path="*" element={<PageNotFound/>}/>
                </Routes>
            </div>
        </Router>
    )
}

export default App;