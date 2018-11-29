package interview.endpoint;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import interview.domain.Interview;
import interview.service.InterviewService;
import interview.system.util.Result;
import interview.system.util.ResultCode;
import interview.system.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/interview")
@Api(tags= {"Interview"}, description="Interview Resource")
public class InterviewEndpoint {
	@Resource
    private InterviewService interviewService;

    @PostMapping
    @ApiOperation(value="add interview", notes="add an interview resource")
    public Result add(@RequestBody Interview interview) {
        Interview current = interviewService.save(interview);
        current.add(linkTo(methodOn(InterviewEndpoint.class).detail(current.getIdinterview())).withSelfRel());
        return ResultGenerator.genSuccessResult().setCode(ResultCode.CREATED).setData(current);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="archive interview", notes="archive an interview resource")
    public Result delete(@PathVariable Integer id) {
    	interviewService.logicDeleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ApiOperation(value="update interview", notes="update an interview resource")
    public Result update(@RequestBody Interview Interview) {
        Interview current = interviewService.update(Interview);
        current.add(linkTo(methodOn(InterviewEndpoint.class).detail(current.getIdinterview())).withSelfRel());
        return ResultGenerator.genSuccessResult().setData(current);
    }

    @GetMapping("/{id}")
    @ApiOperation(value="find interview", notes="find an interview resource by id")
    public Result detail(@PathVariable Integer id) {
        Optional<Interview> Interview = interviewService.findById(id);
        Interview interview2 = Interview.get();
        interview2.add(linkTo(methodOn(InterviewEndpoint.class).detail(id)).withSelfRel());
        return ResultGenerator.genSuccessResult(interview2);
    }
    @GetMapping("/owner")
    @ApiOperation(value="find interview by owner", notes="find an interview resource by id")
    public Result findByOwner(@RequestParam( value = "owner" , required = true,defaultValue = "") String owner) {
    	List<Interview> byOwner = interviewService.findByOwner(owner);
    	for (Interview interview : byOwner) {
    		interview.add(linkTo(methodOn(InterviewEndpoint.class).detail(interview.getIdinterview())).withSelfRel());
		}
    	return ResultGenerator.genSuccessResult(byOwner);
    }
    @GetMapping("/cv")
    @ApiOperation(value="find interview by cv", notes="find an interview resource by cv")
    public Result findByCV(@RequestParam(value = "cv" , required = true,defaultValue = "") String cv) {
    	List<Interview> byCV = interviewService.findByCV(cv);
    	for (Interview interview : byCV) {
    		interview.add(linkTo(methodOn(InterviewEndpoint.class).detail(interview.getIdinterview())).withSelfRel());
    	}
    	return ResultGenerator.genSuccessResult(byCV);
    }
    @GetMapping("/status")
    @ApiOperation(value="find interview by status", notes="find an interview resource by status")
    public Result findByStatus(@RequestParam( value = "status" , required = true,defaultValue = "") String status) {
    	List<Interview> byStatus = interviewService.findByStatus(status);
    	for (Interview interview : byStatus) {
    		interview.add(linkTo(methodOn(InterviewEndpoint.class).detail(interview.getIdinterview())).withSelfRel());
    	}
    	return ResultGenerator.genSuccessResult(byStatus);
    }
    @GetMapping("/position")
    @ApiOperation(value="find interview by position", notes="find an interview resource by position")
    public Result findByPosition(@RequestParam( value = "position" , required = true,defaultValue = "") String position) {
    	List<Interview> byPosition = interviewService.findByPosition(position);
    	for (Interview interview : byPosition) {
    		interview.add(linkTo(methodOn(InterviewEndpoint.class).detail(interview.getIdinterview())).withSelfRel());
    	}
    	return ResultGenerator.genSuccessResult(byPosition);
    }
    @GetMapping("/du")
    @ApiOperation(value="find interview by du", notes="find an interview resource by du")
    public Result findByDU(@RequestParam( value = "du" , required = true,defaultValue = "") String du) {
    	List<Interview> byDU = interviewService.findByDUAndLine(du, "");
    	for (Interview interview : byDU) {
    		interview.add(linkTo(methodOn(InterviewEndpoint.class).detail(interview.getIdinterview())).withSelfRel());
    	}
    	return ResultGenerator.genSuccessResult(byDU);
    }
    @GetMapping("/dl")
    @ApiOperation(value="find interview by du and line", notes="find an interview resource by du and line")
    public Result findByDUAndLine(@RequestParam( value = "du" , required = true,defaultValue = "") String du,
    		@RequestParam( value = "line" , required = false,defaultValue = "") String line) {
    	List<Interview> byDyDUAndLine = interviewService.findByDUAndLine(du, line);
    	for (Interview interview : byDyDUAndLine) {
    		interview.add(linkTo(methodOn(InterviewEndpoint.class).detail(interview.getIdinterview())).withSelfRel());
    	}
    	return ResultGenerator.genSuccessResult(byDyDUAndLine);
    }

    @GetMapping
    @ApiOperation(value="list interviews", notes="list interview resource by default page and size")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {
    	if (size > 50) {
    		return ResultGenerator.genResult(ResultCode.SC_FORBIDDEN, "size to large", Optional.ofNullable(null));
		}
    	PageRequest pageRequest= PageRequest.of(page, size);
    	List<Optional<Interview>> list = interviewService.list(pageRequest);
    	for (Optional<Interview> optional : list) {
    		optional.get().add(linkTo(methodOn(InterviewEndpoint.class).detail(optional.get().getIdinterview())).withSelfRel());
		}
        return ResultGenerator.genSuccessResult(list);
    }

}
