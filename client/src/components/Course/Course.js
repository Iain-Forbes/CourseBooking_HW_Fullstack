const Course = ({course}) => {

    return (
        <div id="info">
            <h3>{course.name}</h3>
            <p>location: {course.town}</p>
            <p>Star Rating: {course.rating}</p>
        </div>
    )
}

export default Course