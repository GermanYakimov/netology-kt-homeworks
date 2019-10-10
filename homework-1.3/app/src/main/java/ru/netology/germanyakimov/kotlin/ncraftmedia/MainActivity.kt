package ru.netology.germanyakimov.kotlin.ncraftmedia

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.germanyakimov.kotlin.dto.Post

class MainActivity : AppCompatActivity() {
    var post: Post = Post(1, "Netology", "First post in our network!", "20 august 2019")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createdTv.text = post.created
        contentTv.text = post.content
        author.text = post.author

        setLikeBtnDefaults()
        setCommentBtnDefaults()
        setShareBtnDefaults()

        setLikesCount()
        setCommentCount()
        setSharesCount()
    }

    private fun setLikesCount() {
        if (post.likesCount > 0) {
            likesCount.text = post.likesCount.toString()
            if (post.likedByMe) {
                likesCount.setTextColor(Color.parseColor("#FF0000"))
            }
            else {
                likesCount.setTextColor(Color.parseColor("b3b3b3"))
            }
        }
    }

    private fun setCommentCount() {
        if (post.commentsCount > 0) {
            commentsCount.text = post.commentsCount.toString()
            if (post.commentedByMe) {
                commentsCount.setTextColor(Color.parseColor("#FF0000"))
            }
            else {
                commentsCount.setTextColor(Color.parseColor("b3b3b3"))
            }
        }
    }

    private fun setSharesCount() {
        if (post.sharesCount > 0) {
            sharesCount.text = post.sharesCount.toString()
            if (post.sharedByMe) {
                sharesCount.setTextColor(Color.parseColor("#FF0000"))
            }
            else {
                sharesCount.setTextColor(Color.parseColor("b3b3b3"))
            }
        }
    }

    private fun setLikeBtnDefaults() {
        if (post.likedByMe){
            likeBtn.setBackgroundResource(R.drawable.ic_favorite_red_24dp)
        }
        else {
            likeBtn.setBackgroundResource(R.drawable.ic_favorite_inactive_24dp)
        }
    }

    private fun setCommentBtnDefaults() {
        if (post.commentedByMe) {
            commentBtn.setBackgroundResource(R.drawable.ic_comment_red_24dp)
        }
        else {
            commentBtn.setBackgroundResource(R.drawable.ic_comment_inactive_24dp)
        }
    }

    private fun setShareBtnDefaults() {
        if (post.sharedByMe) {
            shareBtn.setBackgroundResource(R.drawable.ic_share_red_24dp)
        }
        else {
            shareBtn.setBackgroundResource(R.drawable.ic_share_inactive_24dp)
        }
    }

    fun likeBtnClicked(view: View) {
        if (post.likedByMe){
            post.likedByMe = false
            likeBtn.setBackgroundResource(R.drawable.ic_favorite_inactive_24dp)
        }
        else {
            likeBtn.setBackgroundResource(R.drawable.ic_favorite_red_24dp)
            post.likedByMe = true
            post.likesCount += 1
        }

        setLikesCount()
    }

    fun commentBtnClicked(view: View) {
        if (post.commentedByMe){
            post.commentedByMe = false
            commentBtn.setBackgroundResource(R.drawable.ic_comment_inactive_24dp)
        }
        else {
            commentBtn.setBackgroundResource(R.drawable.ic_comment_red_24dp)
            post.commentedByMe = true
            post.commentsCount += 1
        }

        setCommentCount()
    }

    fun shareBtnCliked(view: View) {
        if (post.sharedByMe){
            post.sharedByMe = false
            shareBtn.setBackgroundResource(R.drawable.ic_share_inactive_24dp)
        }
        else {
            shareBtn.setBackgroundResource(R.drawable.ic_share_red_24dp)
            post.sharedByMe = true
            post.sharesCount += 1
        }

        setSharesCount()
    }
}
