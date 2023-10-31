package co.edureka.hibernate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;

public class CriteriaTest {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		// --- applying pagination (limit query)
		criteria.setMaxResults(50);
		// criteria.setFirstResult(2);
		criteria.setFirstResult(0);

		// --- applying sorting (order by query)
		// criteria.addOrder(Order.asc("studentName"));
		criteria.addOrder(Order.desc("studentName"));

		criteria.add(Restrictions.like("studentName", "S%"));
		criteria.add(Restrictions.between("studentId", 104, 200));

		List<Student> students = criteria.list();

		printStudents(students);
		System.out.println("----------------------------------------------------------\n");
		
		// --- from Hibernate 5.2+ (HCQL)

		// create javax.persistence.criteria.CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// create javax.persistence.criteria.CriteriaQuery
		CriteriaQuery<Student> criter = builder.createQuery(Student.class);

		criter.from(Student.class);// to specify query roots

		Query<Student> q = session.createQuery(criter);

		List<Student> studs = q.getResultList();
		printStudents(studs);
		
		session.close();
		sfactory.close();
	}

	private static void printStudents(List<Student> students) {
		students.forEach(st -> {
			System.out.println(st);
			try {
				TimeUnit.SECONDS.sleep(1); // Thread.sleep(1000);
			} catch (Exception ex) {
			}
		});
	}

}
