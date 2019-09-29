package ru.netology.kotlin.ncraftmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.kotlin.ncraftmedia.ru.netology.kotlin.dto.Post

class MainActivity : AppCompatActivity() {
    var post: Post = Post(1, "Vasya", "First post in our network!", "20 august 2019")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createdTv.text = post.created
        contentTv.text = post.content

        setLikeBtnDefaults()
        setCommentBtnDefaults()
        setShareBtnDefaults()
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
        }
    }

    fun commentBtnClicked(view: View) {
        if (post.commentedByMe){
            post.commentedByMe = false
            commentBtn.setBackgroundResource(R.drawable.ic_comment_inactive_24dp)
        }
        else {
            commentBtn.setBackgroundResource(R.drawable.ic_comment_red_24dp)
            post.commentedByMe = true
        }
    }

    fun shareBtnCliked(view: View) {
        if (post.sharedByMe){
            post.sharedByMe = false
            shareBtn.setBackgroundResource(R.drawable.ic_share_inactive_24dp)
        }
        else {
            shareBtn.setBackgroundResource(R.drawable.ic_share_red_24dp)
            post.sharedByMe = true
        }
    }
}
