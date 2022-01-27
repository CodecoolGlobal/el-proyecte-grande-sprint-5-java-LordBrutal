import React from "react";
import Main from "./pages/Main";
import {BrowserRouter as Router, Switch, Route, Routes} from "react-router-dom";
import "./App.css"
import Navbar from "./Navbar";
import Ingredients from "./pages/Ingredients";
import CreateRecipe from "./pages/CreateRecipe";

function App() {
    return (
        <Router>
            <div className="App">
                <Navbar/>
                <Routes>
                    <Route path="/" element={<Main/>} exact/>
                    <Route path="/ingredient" element={<Ingredients/>}/>
                    <Route path="/create-recipe" element={<CreateRecipe/>}/>
                </Routes>
            </div>
        </Router>
    )
}

export default App;