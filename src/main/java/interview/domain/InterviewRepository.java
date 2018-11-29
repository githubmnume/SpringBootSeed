/**
 * 
 */
package interview.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.String;
import interview.domain.Interview;
import java.util.List;
import java.util.Date;

/**
 * @author zhouufen
 *
 */
public interface InterviewRepository extends JpaRepository<Interview, Integer> {

	List<Interview> findByInOwnerAndInEnable(String inowner,boolean enable);
	List<Interview> findByCvIdAndInEnable(int cvid,boolean enable);
	List<Interview> findByInStatusAndInEnable(String instatus,boolean enable);
	List<Interview> findByInPositionAndInEnable(String inposition,boolean enable);
	List<Interview> findByInDuAndInEnable(String indu,boolean enable);
	List<Interview> findByInDuAndInLineAndInEnable(String indu,String inline,boolean enable);
	List<Interview> findByInDateAndInEnable(Date indate,boolean enable);
	List<Interview> findByInDateBeforeAndInEnable(Date indate,boolean enable);
	List<Interview> findByInDateAfterAndInEnable(Date indate,boolean enable);
	List<Interview> findByInDateBetweenAndInEnable(Date from,Date to,boolean enable);
//	findByLastnameOrderByFirstnameAsc
}
