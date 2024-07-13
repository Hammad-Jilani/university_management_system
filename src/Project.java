import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Project extends JFrame implements ActionListener {
    public Project(){


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1300,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1300,700);
        add(image);

        JMenuBar menuBar = new JMenuBar();
//Information
        JMenu information = new JMenu("Add New Information");
        information.setForeground(Color.BLUE);
        menuBar.add(information);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        information.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        information.add(studentInfo);
//Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLUE);
        menuBar.add(details);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        //Details
        JMenu Leaves = new JMenu("Apply For Leaves");
        Leaves.setForeground(Color.BLUE);
        menuBar.add(Leaves);

        JMenuItem facultyLeaves = new JMenuItem("Faculty Leaves");
        facultyLeaves.addActionListener(this);
        facultyLeaves.setBackground(Color.WHITE);
        Leaves.add(facultyLeaves);

        JMenuItem studentLeaves = new JMenuItem("Student Leaves");
        studentLeaves.addActionListener(this);
        studentLeaves.setBackground(Color.WHITE);
        Leaves.add(studentLeaves);

        JMenu leaveDetails = new JMenu("Leaves Details");
        leaveDetails.setForeground(Color.BLUE);
        menuBar.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leaves Details");
        facultyLeaveDetails.addActionListener(this);
        facultyLeaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leaves Details");
        studentLeaveDetails.addActionListener(this);
        studentLeaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(studentLeaveDetails);

//        Exam
        JMenu exams = new JMenu("Examination");
        exams.setForeground(Color.BLUE);
        menuBar.add(exams);

        JMenuItem Results = new JMenuItem("Examination Result");
        Results.setBackground(Color.WHITE);
        Results.addActionListener(this);
        exams.add(Results);

        JMenuItem marks = new JMenuItem("Enter Marks");
        marks.setBackground(Color.WHITE);
        marks.addActionListener(this);
        exams.add(marks);

        //Update
        JMenu updateInfo = new JMenu("Update Information");
        updateInfo.setForeground(Color.BLUE);
        menuBar.add(updateInfo);

        JMenuItem UpdateFacultyDetails = new JMenuItem("Update Faculty Details");
        UpdateFacultyDetails.setBackground(Color.WHITE);
        updateInfo.add(UpdateFacultyDetails);

        JMenuItem updateStudentDetails = new JMenuItem("Update Student Details");
        updateStudentDetails.setBackground(Color.WHITE);
        updateStudentDetails.addActionListener(this);
        updateInfo.add(updateStudentDetails);

//        fees
        JMenu fees = new JMenu("Fees");
        fees.setForeground(Color.BLUE);
        menuBar.add(fees);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fees.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Student fee form");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fees.add(feeForm);

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        menuBar.add(utility);

        JMenuItem notes = new JMenuItem("NotePad");
        notes.setBackground(Color.WHITE);
        notes.addActionListener(this);
        utility.add(notes);

        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.setBackground(Color.WHITE);
        Calculator.addActionListener(this);
        utility.add(Calculator);

        JMenu Exit = new JMenu("Exit");
        Exit.setForeground(Color.BLUE);
        menuBar.add(Exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        ex.addActionListener(this);
        Exit.add(ex);

        setJMenuBar(menuBar);
        setBounds(0,0,1300,700);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Project();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Exit"){
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else if (e.getActionCommand() =="Calculator" ) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand() == "NotePad") {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand() == "New Faculty Information") {
            setVisible(false);
            new AddTeacher();
        }else if (e.getActionCommand() == "New Student Information"){
            setVisible(false);
            new AddStudent();
        } else if (e.getActionCommand() == "View Student Details") {
            new StudentDetails();
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else if (e.getActionCommand() == "View Faculty Details") {
            new TeacherDetails();
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else if (e.getActionCommand() == "Faculty Leaves") {
            new TeacherLeave();
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else if (e.getActionCommand() == "Student Leaves") {
            new StudentLeave();
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else if (e.getActionCommand() == "Faculty Leaves Details") {
            new TeacherLeaveDetail();
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else if (e.getActionCommand() == "Student Leaves Details") {
            new StudentLeaveDetails();
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else if (e.getActionCommand() == "Enter Marks") {
            new EnterMarks();
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else if (e.getActionCommand() == "Examination Result") {
            new Examination();
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else if (e.getActionCommand() == "Fee Structure") {
            new FeeStructure();
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } else if (e.getActionCommand() == "Student fee form") {
            new PayFee();
            setVisible(false);
        }
    }
}
