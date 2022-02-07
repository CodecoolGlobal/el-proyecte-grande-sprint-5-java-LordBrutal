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

function App() {
    return (
        <Router>
            <div className="App">
                <Navbar/>
                <Routes>
                    <Route path="/" element={<Main/>} exact/>
                    <Route path="/ingredient" element={<Ingredients/>}/>
                    <Route path="/create-recipe" element={<CreateRecipe/>}/>
                    <Route path="/create-customer" element={<AddCustomer/>}/>
                    <Route path={"/create-order"} element={<AddNewOrder/>}/>
                    <Route path="/list-active-orders" element={<ActiveOrders/>}/>
                </Routes>
            </div>
        </Router>
    )
}

export default App;