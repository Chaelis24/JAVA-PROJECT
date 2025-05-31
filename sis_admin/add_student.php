<?php
include "db_connection.php";

$programs = mysqli_query($conn, "SELECT * FROM tbl_program");
$blocks = mysqli_query($conn, "SELECT * FROM tbl_block");
$schools = mysqli_query($conn, "SELECT * FROM tbl_school_year");
$year_levels = mysqli_query($conn, "SELECT * FROM tbl_year_level");

$error = "";

if (isset($_POST["submit"])) {
    $firstname = trim($_POST["first_name"]);
    $middlename = trim($_POST["middle_name"]);
    $lastname = trim($_POST["last_name"]);
    $gender = $_POST["gender"] ?? '';
    $address = trim($_POST["address"]);
    $email = trim($_POST["email"]);
    $birthdate = $_POST["date_of_birth"];
    $phoneNumber = trim($_POST["phone_number"]);
    $program_id = $_POST["program_id"];
    $block_id = $_POST["block_id"];
    $year_level_id = $_POST["year_level_id"];
    $school_year_id = $_POST["school_year_id"];

    if (
        empty($firstname) || empty($lastname) || empty($gender) ||
        empty($address) || empty($email) || empty($birthdate) || empty($phoneNumber) ||
        empty($program_id) || empty($block_id) || empty($year_level_id) || empty($school_year_id)
    ) {
        $error = "Please fill in all required fields.";
    } else {
        $sql = "INSERT INTO `tbl_student`
            (`student_id`, `first_name`, `middle_name`, `last_name`, `gender`, `address`, `email`, `date_of_birth`, `phone_number`, `is_archived`, `block_id`, `program_id`, `year_level_id`, `school_year_id`)
            VALUES
            (NULL, '$firstname', '$middlename', '$lastname', '$gender', '$address', '$email', '$birthdate', '$phoneNumber', 0, '$block_id', '$program_id', '$year_level_id', '$school_year_id')";

        $result = mysqli_query($conn, $sql);

        if ($result) {
            header("Location: index.php?msg=Added Successfully!");
            exit;
        } else {
            $error = "Database Error: " . mysqli_error($conn);
        }
    }
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Student Information System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="styles/styles.css" />
</head>
<body>
    <div class="offcanvas offcanvas-start d-md-none bg-dark text-white" tabindex="-1" id="sidebar" aria-labelledby="sidebarLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="sidebarLabel">Menu</h5>
            <button type="button" class="btn-close btn-close-white text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <div class="text-center mb-4">
                <img src="img/bg-removed.png" alt="Logo" class="img-circle img-fluid" />
            </div>
            <ul class="nav flex-column sidebar">
                <li class="nav-item py-1"><a href="index.php" class="nav-link text-white active"><i class="bi bi-house-door-fill me-1"></i> Home</a></li>
                <li class="nav-item py-1"><a href="add_student.php" class="nav-link text-white"><i class="bi bi-plus-circle-fill me-1"></i> Add Student</a></li>
                <li class="nav-item py-1"><a href="retrieve_student.php" class="nav-link text-white"><i class="bi bi-person-lines-fill me-1"></i> View Students</a></li>
                <li class="nav-item py-1"><a href="#" class="nav-link text-white"><i class="bi bi-question-circle-fill me-1"></i> FAQ</a></li>
                <li class="nav-item py-3"><a href="#" class="nav-link text-white text-center"><i class="bi bi-box-arrow-right me-1"></i> Log Out</a></li>
            </ul>
        </div>
    </div>

    <div class="container-fluid px-0">
        <div class="row g-0">
            <nav class="d-none d-md-flex col-md-3 col-lg-2 bg-dark text-white flex-column p-3" style="min-height: 100vh;">
                <div class="text-center mb-4">
                    <img src="img/bg-removed.png" alt="Logo" class="img-circle img-fluid" />
                </div>
                <ul class="nav flex-column sidebar">
                    <li class="nav-item py-1"><a href="index.php" class="nav-link text-white active"><i class="bi bi-house-door-fill me-1"></i> Home</a></li>
                    <li class="nav-item py-1"><a href="add_student.php" class="nav-link text-white"><i class="bi bi-plus-circle-fill me-1"></i> Add Student</a></li>
                    <li class="nav-item py-1"><a href="retrieve_student.php" class="nav-link text-white"><i class="bi bi-person-lines-fill me-1"></i> View Students</a></li>
                    <li class="nav-item py-1"><a href="#" class="nav-link text-white"><i class="bi bi-question-circle-fill me-1"></i> FAQ</a></li>
                </ul>
                <div class="mt-auto pt-3">
                    <a href="#" class="nav-link text-white text-center"><i class="bi bi-box-arrow-right me-1"></i> Log Out</a>
                </div>
            </nav>

            <main class="col-md-9 col-lg-10">
                <header class="d-flex justify-content-between align-items-center p-3" style="background-color: #108500;">
                    <div class="d-flex align-items-center text-white">
                        <button class="btn btn-light d-md-none me-3" type="button" data-bs-toggle="offcanvas" data-bs-target="#sidebar" aria-controls="sidebar" aria-label="Toggle sidebar">
                            <i class="bi bi-list"></i>
                        </button>
                        <div>
                            <h5 class="mb-0">Top Link Global College, Inc.</h5>
                            <small>Liwag Building, Cabanatuan City, Nueva Ecija</small>
                        </div>
                    </div>
                    <div class="d-flex align-items-center" style="font-size: 0.85rem;">
                        <img src="img/admin.png" alt="Admin" class="img-circle-sm img-fluid" style="width:30px; height:30px; object-fit:cover;" />
                        <span class="text-white fw-bold ms-2">Admin</span>
                    </div>
                </header>

                <div class="container py-4 text-white">
                    <div class="row justify-content-center mb-4">
                        <form action="" method="POST" class="needs-validation" novalidate>
                            <h3 class="text-center mb-4">Add Student</h3>

                            <h5>Student Name</h5>
                            <div class="row g-3">
                                <div class="col-12 col-md-4">
                                    <input type="text" class="form-control" id="first_name" name="first_name" placeholder="First Name" required>
                                </div>
                                <div class="col-12 col-md-4">
                                    <input type="text" class="form-control" id="middle_name" placeholder="Middle Name" name="middle_name">
                                </div>
                                <div class="col-12 col-md-4">
                                    <input type="text" class="form-control" id="last_name" name="last_name" placeholder="Last Name" required>
                                </div>
                            </div>

                            <div class="row mt-2 g-3">
                                <div class="col-12 col-md-4">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                                </div>
                                <div class="col-12 col-md-4">
                                    <label for="phone_number" class="form-label">Phone Number</label>
                                    <input type="tel" class="form-control" id="phone_number" name="phone_number" placeholder="+63" required>
                                </div>
                                <div class="col-12 col-md-4">
                                    <label for="address" class="form-label">Address</label>
                                    <textarea class="form-control" id="address" name="address" rows="1" placeholder="Complete Address" required></textarea>
                                </div>
                            </div>

                            <div class="row mt-2 g-3">
                                <div class="col-12 col-md-4">
                                    <label for="date_of_birth" class="form-label">Birthdate</label>
                                    <input type="date" class="form-control" id="date_of_birth" name="date_of_birth" required>
                                </div>
                                <div class="col-12 col-md-4">
                                    <label for="gender" class="form-label">Gender</label>
                                    <select class="form-select" id="gender" name="gender" required>
                                        <option value="" disabled selected>Select gender</option>
                                        <option value="Male">Male</option>
                                        <option value="Female">Female</option>
                                    </select>
                                </div>
                            </div>

                            <div class="row mt-2 g-3">
                                <div class="col-12 col-md-3">
                                    <label for="program_id" class="form-label">Course</label>
                                    <select class="form-select" name="program_id" id="program_id" required>
                                        <option value="">Select Course</option>
                                        <?php while ($row = $programs->fetch_assoc()) { ?>
                                            <option value="<?= $row['program_id'] ?>"><?= $row['program_name'] ?></option>
                                        <?php } ?>
                                    </select>
                                </div>
                                <div class="col-12 col-md-3">
                                    <label for="block_id" class="form-label">Block</label>
                                    <select class="form-select" name="block_id" id="block" required>
                                        <option value="">Select Block</option>
                                        <?php while ($row = $blocks->fetch_assoc()) { ?>
                                            <option value="<?= $row['block_id'] ?>"><?= $row['block_name'] ?></option>
                                        <?php } ?>
                                    </select>
                                </div>
                                <div class="col-12 col-md-3">
                                    <label for="year_level_id" class="form-label">Year Level</label>
                                    <select class="form-select" name="year_level_id" id="year_level" required>
                                        <option value="">Select Year Level</option>
                                        <?php while ($row = $year_levels->fetch_assoc()) { ?>
                                            <option value="<?= $row['year_level_id'] ?>"><?= $row['level_name'] ?></option>
                                        <?php } ?>
                                    </select>
                                </div>
                                <div class="col-12 col-md-3">
                                    <label for="school_year_id" class="form-label">School Year</label>
                                    <select class="form-select" name="school_year_id" id="school_year_id" required>
                                        <option value="">Select School Year</option>
                                        <?php while ($row = $schools->fetch_assoc()) { ?>
                                            <option value="<?= $row['school_year_id'] ?>"><?= $row['year_label'] ?></option>
                                        <?php } ?>
                                    </select>
                                </div>
                            </div>

                            <div class="row mt-4">
                                <div class="col-12 d-flex flex-column flex-md-row justify-content-md-end gap-2">
                                    <button type="submit" class="btn bg-primary text-white" name="submit">Add Student</button>
                                    <a href="index.php" class="btn bg-danger text-white">Cancel</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
