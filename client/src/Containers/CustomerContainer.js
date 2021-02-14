import Customer from "../components/Customer/Customer"
import CustomerList  from "../components/Customer/CustomerList"

const CustomerConatiner = ({customers}) => {

    return(
    <div>
        <h1>Customers</h1>
        <div className="customers">
            <CustomerList customers={customers}/>
        </div>
    </div>
    )
}

export default CustomerConatiner