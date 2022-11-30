<template class="feed" id="template_cuack">
    <div class="feed">
        <div class="head">
            <div class="user">
                <a class="profile-photo" href="">
                    <img class="profile-photo_img" src="">
                </a>
                <div class="ingo">
                    <div style="display: inline-flex; align-items: baseline; gap: 0.5rem">
                        <h3></h3>
                        <small class="text-muted">(El )</small>
                    </div>

                    <h2></h2>
                </div>
            </div>
            <span class="edit">
            <i class="uil uil-ellipsis-h"></i>
        </span>
        </div>

        <div class="photo">
            <a class="photo_a" href="" target="_blank">
                <img class="photo_img" src=""/></a>
        </div>

        <div class="action-button">
            <div class="interaction-buttons">

                <span class="interaction-buttons_span" onclick="">
                    <i class="like fa-regular fa-heart"></i>
                </span>

                <a class="comment_a" href="">
                <span>
                    <i class="comment fa-regular fa-comment-dots"></i>
                </span>
                </a>
            </div>
        </div>

        <p style="margin-bottom: 0.5rem"><b><span class="like-counter"></span></b> Me gusta</p>

        <div class="caption">
            <p>
                <b class="cuack-author"></b>
                <span class="cuack-content"></span>
                <b><i class="cuack-edited"></i></b>
                <span class="harsh-tag"><b class="tag"></b></span>
            </p>
        </div>
    </div>
</template>