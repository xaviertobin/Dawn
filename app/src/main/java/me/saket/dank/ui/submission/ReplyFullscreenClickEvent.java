package me.saket.dank.ui.submission;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import net.dean.jraw.models.Contribution;
import net.dean.jraw.models.PublicContribution;

@AutoValue
public abstract class ReplyFullscreenClickEvent {

  public abstract long replyRowItemId();

  public abstract Contribution parentContribution();

  public abstract String replyMessage();

  @Nullable
  public abstract String authorNameIfComment();

  public static ReplyFullscreenClickEvent create(long replyRowItemId, PublicContribution parentContribution, String replyMessage,
      String authorNameIfComment)
  {
    return new AutoValue_ReplyFullscreenClickEvent(replyRowItemId, parentContribution, replyMessage, authorNameIfComment);
  }
}
