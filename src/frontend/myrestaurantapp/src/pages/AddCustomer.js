function AddCustomer() {
    return (<div className="form-container">
        <div className="add-user-baackround">
            <form action="http://localhost:8080/api/add-customer" method="POST">
                <label className="label-text">Name<br/>
                    <input className="label-input" type="text"  width="100px" name="name" autoComplete="off" required/>
                </label><br/>
                <label className="label-text">Email<br/>
                    <input className="label-input" type="text" name="email" autoComplete="off" required/>
                </label><br/>
                <label className="label-text">Phone Number<br/>
                    <input className="label-input" type="text" name="phoneNumber" autoComplete="off" required/>
                </label><br/>
                <label className="label-text">City Name<br/>
                    <input className="label-input" type="text" name="cityName" autoComplete="off" required/>
                </label><br/>
                <label className="label-text">Street Name<br/>
                    <input className="label-input" type="text" name="streetName" autoComplete="off" required/>
                </label><br/>
                <label className="label-text">House Number<br/>
                    <input className="label-input" type="number" name="houseNumber" autoComplete="off" required/>
                </label><br/>
                <button className="submit-button" type="submit">Save me</button>
            </form>
        </div>
    </div>)
}

export default AddCustomer;
