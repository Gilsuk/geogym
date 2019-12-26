package com.geogym.attachment.dao;

import com.geogym.attachment.dto.Attachment;
import com.geogym.trainer.dto.Trainer;

public interface AttachmentDao {

	void upload(Attachment attachment);

	Attachment getAttachment(Trainer trainer);



}
