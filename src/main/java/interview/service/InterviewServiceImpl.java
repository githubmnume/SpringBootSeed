/**
 * 
 */
package interview.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import interview.domain.Interview;
import interview.domain.InterviewRepository;
import interview.system.exception.ServiceException;

/**
 * @author zhouufen
 * @param <T>
 *
 */
@Service
public class InterviewServiceImpl implements InterviewService {
	private static Logger logger = LoggerFactory.getLogger(InterviewServiceImpl.class);
	@Autowired
	private InterviewRepository interviewRepository;

	@Override
	public Interview save(Interview model) {
		Interview save = null;
		try {
			save = interviewRepository.save(model);
		} catch (Exception e) {
			logger.error(String.format("save Interview=%s failed", model), e);
			throw new ServiceException("save failed");
		}
		return save;
	}

	@Override
	public List<Interview> saveAll(List<Interview> models) {
		List<Interview> list = null;
		try {
			list = interviewRepository.saveAll(models);
		} catch (Exception e) {
			logger.error(String.format("save Interviews=%s failed", models), e);
			throw new ServiceException("save list failed");
		}
		return list;
	}

	@Override
	public void logicDeleteByIds(List<Integer> ids) {
		try {
			for (Integer id : ids) {
				interviewRepository.deleteById(id);
			}
		} catch (Exception e) {
			logger.error(String.format("delete id=%s failed", ids), e);
			throw new ServiceException("delete ids failed");
		}

	}

	@Override
	public Interview update(Interview model) {
		Interview interview=null;
		try {
			interview = this.save(model);
		} catch (Exception e) {
			logger.error(String.format("update Interview=%s failed", model), e);
			throw new ServiceException("update failed");
		}
		return interview;
	}

	@Override
	public void logicDeleteById(Integer id) {
		try {
			Optional<Interview> present = Optional.ofNullable(interviewRepository.findById(id))
					.orElseThrow(() -> new ServiceException(String.format("disable id=%s failed", id)));
			Interview result = present.get();
			result.setInEnable(false);
			this.save(result);
		} catch (Exception e) {
			logger.error(String.format("disable id=%s failed", id), e);
			throw new ServiceException(String.format("disable id=%s failed", id));
			// return String.format(
			// "Interview [idinterview=%s, in_du=%s, in_line=%s, in_position=%s,
			// in_status=%s, in_comment=%s, in_owner=%s, cv_id=%s, in_date=%s,
			// in_last_update_date=%s]",
			// idinterview, in_du, in_line, in_position, in_status, in_comment, in_owner,
			// cv_id, in_date,
			// in_last_update_date);
		}

	}

	@Override
	public Optional<Interview> findById(Integer id) throws ServiceException {
		Optional<Interview> optional;
		try {
			optional = Optional.ofNullable(interviewRepository.findById(id)).orElse(null);
		} catch (Exception e) {
			logger.error(String.format("find Interview=%s failed", id), e);
			throw new ServiceException("find failed");
		}
		return optional;

	}

	@Override
	public List<Optional<Interview>> list(Pageable pageable) throws ServiceException {
		List<Optional<Interview>> list = new LinkedList<>();
		try {
			Page<Interview> all = interviewRepository.findAll(pageable);
			for (Interview interview : all) {
				list.add(Optional.ofNullable(interview));
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public List<Interview> findByOwner(String owner) throws ServiceException {
		List<Interview> findByInOwner = null;
		try {
			findByInOwner = interviewRepository.findByInOwnerAndInEnable(owner, true);
		} catch (Exception e) {
			logger.error(String.format("find Interview Owner=%s failed", owner), e);
			throw new ServiceException(String.format("can't find Interview Owner=%s", owner));
		}
		return findByInOwner;
	}

	@Override
	public List<Interview> findByCV(String cvid) throws ServiceException {
		List<Interview> findByInCV = null;
		try {
			int parseInt = Integer.parseInt(cvid);
			findByInCV = interviewRepository.findByCvIdAndInEnable(parseInt, true);
		} catch (Exception e) {
			logger.error(String.format("find Interview cv=%s failed", cvid), e);
			throw new ServiceException(String.format("can't find Interview Owner=%s", cvid));
		}
		return findByInCV;
	}

	@Override
	public List<Interview> findByStatus(String status) throws ServiceException {
		List<Interview> findByStatus = null;
		try {
			findByStatus = interviewRepository.findByInStatusAndInEnable(status, true);// default find true
		} catch (Exception e) {
			logger.error(String.format("find Interview status=%s failed", status), e);
			throw new ServiceException(String.format("can't find Interview status=%s", status));
		}
		return findByStatus;
	}

	@Override
	public List<Interview> findByPosition(String position) throws ServiceException {
		List<Interview> findByPosition = null;
		try {
			findByPosition = interviewRepository.findByInPositionAndInEnable(position, true);// default find true
		} catch (Exception e) {
			logger.error(String.format("find Interview position=%s failed", position), e);
			throw new ServiceException(String.format("can't find Interview position=%s", position));
		}
		return findByPosition;
	}

	@Override
	public List<Interview> findByDUAndLine(String du, String line) throws ServiceException {
		List<Interview> findByDUAndLine = null;
		try {
			if (!du.isEmpty() && !line.isEmpty()) {
				findByDUAndLine = interviewRepository.findByInDuAndInLineAndInEnable(du, line, true);// default find true
			}
			else if (!du.isEmpty() && line.isEmpty()) {
				findByDUAndLine = interviewRepository.findByInDuAndInEnable(du, true);// default find true
			}
		} catch (Exception e) {
			logger.error(String.format("find Interview du=%s failed", du), e);
			throw new ServiceException(String.format("can't find Interview du=%s", du));
		}
		return findByDUAndLine;
	}

	@Override
	public List<Interview> findByDate(Date date) throws ServiceException {
		List<Interview> findByIndate = null;
		try {
			findByIndate = interviewRepository.findByInDateAndInEnable(date, true);// default find true
		} catch (Exception e) {
			logger.error(String.format("find Interview date=%s failed", date), e);
			throw new ServiceException(String.format("can't find Interview date=%s", date));
		}
		return findByIndate;
	}

	@Override
	public List<Interview> findByDateBefore(Date dateBefore) throws ServiceException {
		// TODO Auto-generated method stub
		List<Interview> findByIndateBefore = null;
		try {
			findByIndateBefore = interviewRepository.findByInDateBeforeAndInEnable(dateBefore, true);// default find
																										// true
		} catch (Exception e) {
			logger.error(String.format("find Interview dateBefore=%s failed", dateBefore), e);
			throw new ServiceException(String.format("can't find Interview dateBefore=%s", dateBefore));
		}
		return findByIndateBefore;
	}

	@Override
	public List<Interview> findByDateAfter(Date dateAfter) throws ServiceException {
		List<Interview> findByIndateAfter = null;
		try {
			findByIndateAfter = interviewRepository.findByInDateAfterAndInEnable(dateAfter, true);// default find true
		} catch (Exception e) {
			logger.error(String.format("find Interview dateAfter=%s failed", dateAfter), e);
			throw new ServiceException(String.format("can't find Interview dateAfter=%s", dateAfter));
		}
		return findByIndateAfter;
	}

	@Override
	public List<Interview> findByDateBetween(Date datefrom, Date dateto) throws ServiceException {
		List<Interview> findByIndateBetween = null;
		try {
			findByIndateBetween = interviewRepository.findByInDateBetweenAndInEnable(datefrom, dateto, true);// default
																												// find
																												// true
		} catch (Exception e) {
			logger.error(String.format("find Interview between [%s,%s] failed", datefrom, dateto), e);
			throw new ServiceException(String.format("can't find Interview between [%s,%s]", datefrom, dateto));
		}
		return findByIndateBetween;
	}

}
