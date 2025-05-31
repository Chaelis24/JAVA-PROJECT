<?php
include "db_connection.php";

if (isset($_GET['student_id'])) {
    $student_id = intval($_GET['student_id']);
    $sql = "UPDATE tbl_student SET is_archived = 0 WHERE student_id = $student_id";
    $result = mysqli_query($conn, $sql);

    if ($result) {
        header("Location: archived_students.php?msg=Restored successfully.");
        exit;
    } else {
        echo "Error restoring student: " . mysqli_error($conn);
    }
} else {
    echo "No student ID provided.";
}
?>
