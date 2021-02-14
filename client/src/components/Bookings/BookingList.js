import Booking from "./Booking"

const BookingDisplay = ({bookings}) => {

    const bookingList = bookings.map((booking, index) => {

        return (
            <Booking 
                date={booking.date}
                course={booking.course.name}
                customer={booking.customer.name}
                key={booking.id} />
    
        )
    })

    return(
        <div>
            <h2>Bookings List</h2>
            <ul id="list">
                {bookingList}
            </ul>
        </div>
    )

}

export default BookingDisplay;