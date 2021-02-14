const Customer = ({customer}) => {

    return(
        <div id='custInfo'>
         <h2>{customer.name}</h2>
            <p>Location: {customer.town}</p>
            <p>Age: {customer.age}</p>
        </div>
    )
}

export default Customer;