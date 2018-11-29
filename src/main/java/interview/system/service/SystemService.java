/**
 * 
 */
package interview.system.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import interview.system.exception.ServiceException;

/**
 * @author zhouufen
 *
 */
public interface SystemService<T> {
	//CRUD
	 T save(T model) throws ServiceException;//持久化
	 List<T> saveAll(List<T> models) throws ServiceException;//批量持久化
	 void logicDeleteById(Integer id)throws ServiceException;//通过主鍵刪除
	 void logicDeleteByIds(List<Integer> ids)throws ServiceException;//批量刪除 eg：ids -> “1,2,3,4”
	 T update(T model);//更新
	 Optional<T> findById(Integer id)throws ServiceException;//通过主鍵查找
	 List<Optional<T>> list(Pageable pageable)throws ServiceException;//pageable
	 List<T> findByOwner(String owner) throws ServiceException;//批量持久化
	 List<T> findByCV(String cvid) throws ServiceException;//批量持久化
	 List<T> findByStatus(String status) throws ServiceException;//
	 List<T> findByPosition(String position) throws ServiceException;//
	 List<T> findByDUAndLine(String du,String line) throws ServiceException;//
	 List<T> findByDate(Date date) throws ServiceException;
	 List<T> findByDateBefore(Date dateBefore) throws ServiceException;
	 List<T> findByDateAfter(Date dateAfter) throws ServiceException;
	 List<T> findByDateBetween(Date datefrom, Date dateto) throws ServiceException;

}
